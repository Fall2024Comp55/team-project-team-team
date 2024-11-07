
public class Badge {
	BadgeType badge;
	boolean haveBadge;
	String Description;
	
	Badge(BadgeType b){
		badge = b;
		haveBadge = false;
		Description = b.toString();
		
	}
	public String getDescription() {
		return this.Description;
	}
	public void SetDescription(BadgeType d) {
		this.Description = d.toString();
	}
	public void SetHaveBage(boolean b) {
		this.haveBadge = b;
	}
	public boolean GetHaveBage() {
		return this.haveBadge;
	}
	public void SetTypeBadge(BadgeType b) {
		this.badge = b;
	}
	public BadgeType GetBadgeType() {
		return this.badge;
	}
	

	
	
	
}
