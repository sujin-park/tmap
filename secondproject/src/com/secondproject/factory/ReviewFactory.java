package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.review.action.ReviewDeleteAction;
import com.secondproject.review.action.ReviewGoodBadAction;
import com.secondproject.review.action.ReviewModifyFormAction;
import com.secondproject.review.action.ReviewViewAction;
import com.secondproject.review.action.ReviewWriteAction;
import com.secondproject.review.action.ReviewWriteFormAction;

public class ReviewFactory {

	private static Action reviewWriteAction;
	private static Action reviewViewAction;
	private static Action reviewModifyFormAction;
	private static Action reviewWriteFormAction;
	private static Action reviewDeleteAction;
	private static Action reviewGoodBadAction;

	static {
		reviewWriteAction = new ReviewWriteAction();
		reviewViewAction = new ReviewViewAction();
		reviewModifyFormAction = new ReviewModifyFormAction();
		reviewWriteFormAction = new ReviewWriteFormAction();
		reviewDeleteAction = new ReviewDeleteAction();
		reviewGoodBadAction = new ReviewGoodBadAction();
	}

	public static Action getReviewWriteAction() {
		return reviewWriteAction;
	}

	public static Action getReviewViewAction() {
		return reviewViewAction;
	}

	public static Action getReviewModifyFormAction() {
		return reviewModifyFormAction;
	}

	public static Action getReviewWriteFormAction() {
		return reviewWriteFormAction;
	}

	public static Action getReviewDeleteAction() {
		return reviewDeleteAction;
	}

	public static Action getReviewGoodBadAction() {
		return reviewGoodBadAction;
	}

}
