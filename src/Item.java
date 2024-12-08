import acm.graphics.GImage;

public class Item {
    private ItemName itemName;
    private String description;
    private String bagTab;
    private GImage sprite;
    private Badge badge;
    private int amount; // Quantity of the item 

    public Item(ItemName name, BadgeType badgeType, int amount) {
        this.itemName = name;
        this.description = name.getDescription();
        this.bagTab = name.getBagTab();
        this.amount = amount;
        
        if (itemName == ItemName.BADGE) {
            if (badgeType != null) {
                badge = new Badge(badgeType);
            } else {
                throw new IllegalArgumentException("BadgeType cannot be null for BADGE items.");
            }
        }
    }

    public void use(Monster m) {
        if (amount <= 0) {
            System.out.println("You don't have any " + itemName + " left!");
            return;
        }
        
        switch (bagTab) {
            case "Heal":
                System.out.println("Potion Tab");
                HealItem heal = new HealItem();
                heal.SetHeal(itemName.getType());
                heal.Use(m);
                decreaseAmount(1);
                break;

            case "Ball":
                System.out.println("Ball Tab");
                BallItem ball = new BallItem();
                ball.setCatchRate(itemName.getType());
                ball.Use();
                decreaseAmount(1);
                break;

            case "Badge":
                System.out.println("Badge Tab");
                break;

            default:
                System.out.println("Unknown Tab");
                break;
        }
    }

    public ItemName getName() {
        return itemName;
    }

    public void setName(ItemName name) {
        this.itemName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBagTab() {
        return bagTab;
    }

    public GImage getSprite() {
        return sprite;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void increaseAmount(int increment) {
        this.amount += increment;
    }

    public void decreaseAmount(int decrement) {
        if (this.amount >= decrement) {
            this.amount -= decrement;
        } else {
            this.amount = 0; // Prevent negative values
        }
    }
}