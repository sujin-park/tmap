package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.review.action.ReviewWriteAction;

public class ReviewFactory {
	
	private static Action reviewWriteAction;
	
	static {
		reviewWriteAction = new ReviewWriteAction();
	}

	public static  Action getReviewWriteAction() {
		return reviewWriteAction;
	}
	
}
