package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.review.action.ReviewListAction;
import com.secondproject.review.action.ReviewViewAction;
import com.secondproject.review.action.ReviewWriteAction;

public class ReviewFactory {

	private static Action reviewWriteAction;
	private static Action reviewListAction;
	private static Action reviewViewAction;

	static {
		reviewWriteAction = new ReviewWriteAction();
		reviewListAction = new ReviewListAction();
		reviewViewAction = new ReviewViewAction();
	}

	public static Action getReviewWriteAction() {
		return reviewWriteAction;
	}

	public static Action getReviewListAction() {
		return reviewListAction;
	}

	public static Action getReviewViewAction() {
		return reviewViewAction;
	}

}
