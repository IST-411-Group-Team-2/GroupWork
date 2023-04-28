package entities;

//Model Class that generates an auction item entry
public class AuctionItem {
    private int auctionID;
    private String auctionName;
    private String sellerName;
    private String itemDescription;
    private double startingBid;


    //Constructor method
    public AuctionItem(int auctionID, String auctionName, String sellerName, String itemDescription, double startingBid) {
        this.auctionID = auctionID;
        this.auctionName = auctionName;
        this.sellerName = sellerName;
        this.itemDescription = itemDescription;
        this.startingBid = startingBid;
    }

    //Get method for an item's Auction ID
    public int getAuctionID() {
        return this.auctionID;
    }
    //Set method for an item's Auction ID
    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }
    //Get method for an item's name
    public String getAuctionName() {
        return this.auctionName;
    }
    //Set method for an item's name
    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }
    //get method for an item's seller name
    public String getSellerName() {
        return this.sellerName;
    }
    //Set method for an item's seller name
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    //Get method for item description
    public String getItemDescription() {
        return this.itemDescription;
    }
    //Get method for item description
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
    //Get starting bid info
    public double getStartingBid() {
        return this.startingBid;
    }
    //Set a starting bid
    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }

    //Output string method for all Auction Item info
    @Override
    public String toString() {
        return "{" +
            " auctionID='" + getAuctionID() + "'" +
            ", auctionName='" + getAuctionName() + "'" +
            ", sellerName='" + getSellerName() + "'" +
            ", itemDescription='" + getItemDescription() + "'" +
            ", startingBid='" + getStartingBid() + "'" +
            "}";
    }

}
