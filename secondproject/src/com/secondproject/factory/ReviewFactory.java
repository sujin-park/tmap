package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.review.action.ReviewListAction;
import com.secondproject.review.action.ReviewWriteAction;

public class ReviewFactory {

	private static Action reviewWriteAction;
	private static Action reviewListAction;

	static {
		reviewWriteAction = new ReviewWriteAction();
		reviewListAction = new ReviewListAction();
	}

	public static Action getReviewWriteAction() {
		return reviewWriteAction;
	}

	public static Action getReviewListAction() {
		return reviewListAction;
	}

}
