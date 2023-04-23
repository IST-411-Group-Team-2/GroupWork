package controllers;

//Relevant imports
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.AuctionItem;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.AuctionItemService;
// import utils.ApplicationUtil;
import java.util.List;
import views.html.DetailView.*;
import views.html.ListView.*;

//Controller for retrieving Auction Item Info
public class AuctionItemController extends Controller {

    //Get method to return a single auction item
    public Result getAuctionItem(int id) {
        // Return Auction Item for given ID, if invalid ID return all items.
        try {
            return ok(views.html.DetailView.auctionItems.render(AuctionItemService.getInstance().getAuctionItem(id).toString()));
        } catch (Exception e) {
            System.out.println("NOT A VALID INDEX... Returning all values.");
        }
        return getAuctionItems();
    }

    //Get method for returning multiple auction items
    public Result getAuctionItems() {
        List<AuctionItem> auctionItems = AuctionItemService.getInstance().getAllAuctionItems();
        String output = new String();

        for (int i = 0; i < auctionItems.size(); i++) {
            output += auctionItems.get(i).toString() + "\n";
        }

        return ok(views.html.ListView.auctionItems.render(output));
    }
    
}
