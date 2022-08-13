package all.company.com.MachineCoding.TinyUrl;

import java.util.Scanner;
import all.company.com.MachineCoding.TinyUrl.constant.Constants;
import all.company.com.MachineCoding.TinyUrl.entity.Alias;
import all.company.com.MachineCoding.TinyUrl.service.TinyUrlService;
import all.company.com.MachineCoding.TinyUrl.service.TinyUrlServiceImpl;


public class TinyUrlDriver {
    private static final TinyUrlService tinyUrlService;

    static {
        tinyUrlService = new TinyUrlServiceImpl();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------- Tiny URL --------");
        while (true) {
            System.out.println("Command >> ");
            String cmd = sc.nextLine();
            switch (cmd){
                case "create_alias" : {
                    System.out.println("Alias >");
                    String aliasName = sc.nextLine();
                    System.out.println("Full URL >");
                    String fullUrl = sc.nextLine();
                    System.out.println(tinyUrlService.createUrlAlias(fullUrl, aliasName, null, null));
                    break;
                }
                case "alias_available" : {
                    System.out.println("Alias >");
                    String aliasName = sc.nextLine();
                    System.out.println(tinyUrlService.isAliasAvailable(aliasName));
                    break;
                }
                case "sleep" : {
                    System.out.println("Sleep Time >");
                    long sleepTime = Long.parseLong(sc.nextLine());
                    System.out.println("Sleeping for "+sleepTime+" ms");
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e){
                        System.out.println("Interrupted");
                    }
                    break;
                }
                case "get_alias" : {
                    System.out.println("Alias >");
                    String aliasName = sc.nextLine();
                    Alias alias = tinyUrlService.getAlias(aliasName);
                    if(alias == null){
                        System.out.println("No Alias");
                    }
                    System.out.println(Constants.DEFAULT_DOMAIN+alias.getAlias());
                    break;
                }
                case "exit" : {
                    return;
                }
            }
        }
    }
}
