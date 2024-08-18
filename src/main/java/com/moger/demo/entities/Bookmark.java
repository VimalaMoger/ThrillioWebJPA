package com.moger.demo.entities;
import com.moger.demo.DataConstants.KidFriendlyStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Bookmark {

	private long id;
	private String title;
	private String profileUrl;
	private KidFriendlyStatus kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;

	//stub
	public abstract boolean isKidsFriendlyEligible();
}


