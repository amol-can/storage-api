import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.route53.Route53Client;
import software.amazon.awssdk.services.route53.model.*;

import java.util.List;

public class Route53Op {
    private static String hostedZoneId = "Z08028182EHY9UV7R7X1A";

    public static void main(String[] args) {

        Region region = Region.AWS_GLOBAL;
        Route53Client route53Client = Route53Client.builder()
                .region(region)
                .build();

        //listResourceRecord(route53Client, hostedZoneId);
        changeResourceRecordSets(route53Client);
        route53Client.close();
    }

    // API Ref: https://docs.aws.amazon.com/Route53/latest/APIReference/API_ChangeResourceRecordSets.html
    // Java DOC: https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/services/route53/Route53Client.html#changeResourceRecordSets--
    public static ChangeResourceRecordSetsResponse changeResourceRecordSets(Route53Client route53Client) {
        String routeTrafficTo = "www.qstorageplus.com";
        String recordName = "prog.qstorageplus.com";

        ResourceRecord resourceRecord = ResourceRecord.builder()
                .value(routeTrafficTo)
                .build();

        ResourceRecordSet resourceRecordSet = ResourceRecordSet.builder()
                .name(recordName)
                .type(RRType.CNAME)
                .ttl(300L)
                .resourceRecords(resourceRecord)
                .build();
        Change change = Change.builder()
                .action(ChangeAction.CREATE)
                .resourceRecordSet(resourceRecordSet)
                .build();
        ChangeBatch changeBatch = ChangeBatch.builder()
                .changes(change)
                .build();
        ChangeResourceRecordSetsRequest changeResourceRecordSetsRequest = ChangeResourceRecordSetsRequest
                .builder()
                .changeBatch(changeBatch)
                .hostedZoneId(hostedZoneId)
                .build();

        ChangeResourceRecordSetsResponse response = route53Client.changeResourceRecordSets(changeResourceRecordSetsRequest);
        System.out.println("Response of record creation API: " + response);
        // if InvalidChangeBatchException then record already present
        return response;
    }

    public static void listResourceRecord(Route53Client route53Client, String hostedZoneId) {

        try {

            ListResourceRecordSetsRequest request = ListResourceRecordSetsRequest.builder()
                    .hostedZoneId(hostedZoneId)
                    .maxItems("12")
                    .build();

            ListResourceRecordSetsResponse listResourceRecordSets = route53Client.listResourceRecordSets(request);
            List<ResourceRecordSet> records = listResourceRecordSets.resourceRecordSets();

            for (ResourceRecordSet record : records) {
                System.out.println("The Record name is: " + record.name());
            }

        } catch (Route53Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
