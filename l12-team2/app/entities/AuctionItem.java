package entities;

public class AuctionItem {
    private int auctionID;
    private String auctionName;
    private String sellerName;
    private String itemDescription;
    private double startingBid;


    public AuctionItem(int auctionID, String auctionName, String sellerName, String itemDescription, double startingBid) {
        this.auctionID = auctionID;
        this.auctionName = auctionName;
        this.sellerName = sellerName;
        this.itemDescription = itemDescription;
        this.startingBid = startingBid;
    }


    public int getAuctionID() {
        return this.auctionID;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    public String getAuctionName() {
        return this.auctionName;
    }

    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName;
    }

    public String getSellerName() {
        return this.sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getStartingBid() {
        return this.startingBid;
    }

    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }


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