package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.mypage.action.CommentInsertAction;
import com.secondproject.mypage.action.FollowSelectAction;
import com.secondproject.mypage.action.GoodBadAction;
import com.secondproject.mypage.action.MypageFollowAddAction;
import com.secondproject.mypage.action.MypageFollowCategoryDeleteAction;
import com.secondproject.mypage.action.MypageFollowCategoryDownOrderAction;
import com.secondproject.mypage.action.MypageFollowCategoryListViewAction;
import com.secondproject.mypage.action.MypageFollowCategoryMakeAction;
import com.secondproject.mypage.action.MypageFollowCategoryModifyAction;
import com.secondproject.mypage.action.MypageFollowCategoryUpOrderAction;
import com.secondproject.mypage.action.MypageFollowDeleteAction;
import com.secondproject.mypage.action.MypageFollowModifyAction;
import com.secondproject.mypage.action.MypageFollowUserViewAction;
import com.secondproject.mypage.action.MypageFollowViewAction;
import com.secondproject.mypage.action.MypageReviewDeleteAction;
import com.secondproject.mypage.action.MypageReviewListViewAction;
import com.secondproject.mypage.action.MypageReviewViewAction;
import com.secondproject.mypage.action.MypageYourReviewListViewAction;

public class MypageFactory {
	private static Action mypageFollowCategoryMakeAction;
	private static Action mypageFollowCategoryModifyAction;
	private static Action mypageFollowCategoryDeleteAction;
	private static Action mypageFollowCategoryUpOrderAction;
	private static Action mypageFollowCategoryDownOrderAction;
	private static Action mypageFollowCategoryListView;
	private static Action mypageFollowViewAction;
	private static Action mypageFollowAddAction;
	private static Action mypageFollowModifyAction;
	private static Action mypageFollowDeleteAction;
	private static Action mypageReviewListViewAction;
	private static Action mypageReviewDeleteAction;
	private static Action mypageFollowUserViewAction;
	private static Action mypageReviewViewAction;
	private static Action goodBadAction;
	private static Action commentInsertAction;
	private static Action followSelect;
	private static Action mypageYourReviewListViewAction;

	public static Action getMypageFollowCategoryUpOrderAction() {
		return mypageFollowCategoryUpOrderAction;
	}

	public static Action getMypageFollowCategoryDownOrderAction() {
		return mypageFollowCategoryDownOrderAction;
	}

	static {
		mypageFollowCategoryListView= new MypageFollowCategoryListViewAction();
		mypageFollowCategoryMakeAction = new MypageFollowCategoryMakeAction();
		mypageFollowCategoryModifyAction = new MypageFollowCategoryModifyAction();
		mypageFollowCategoryDeleteAction = new MypageFollowCategoryDeleteAction();
		mypageFollowCategoryUpOrderAction = new MypageFollowCategoryUpOrderAction();
		mypageFollowCategoryDownOrderAction = new MypageFollowCategoryDownOrderAction();
		mypageFollowViewAction = new MypageFollowViewAction();
		mypageFollowAddAction = new MypageFollowAddAction();
		mypageFollowModifyAction= new MypageFollowModifyAction();
		mypageFollowDeleteAction = new MypageFollowDeleteAction();
		mypageReviewListViewAction = new MypageReviewListViewAction();
		mypageReviewDeleteAction = new MypageReviewDeleteAction();
		mypageFollowUserViewAction = new MypageFollowUserViewAction();
		mypageReviewViewAction = new MypageReviewViewAction();
		goodBadAction = new GoodBadAction();
		commentInsertAction = new CommentInsertAction();
		followSelect = new FollowSelectAction();
		mypageYourReviewListViewAction = new MypageYourReviewListViewAction();
	}

	
	public static Action getMypageYourReviewListViewAction() {
		return mypageYourReviewListViewAction;
	}

	public static Action getFollowSelect() {
		return followSelect;
	}

	public static Action getCommentInsertAction() {
		return commentInsertAction;
	}

	public static Action getGoodBadAction() {
		return goodBadAction;
	}

	public static Action getMypageReviewListViewAction() {
		return mypageReviewListViewAction;
	}

	public static Action getMypageFollowUserViewAction() {
		return mypageFollowUserViewAction;
	}

	public static Action getMypageFollowCategoryListView() {
		return mypageFollowCategoryListView;
	}

	public static Action getMypageFollowModifyAction() {
		return mypageFollowModifyAction;
	}

	public static Action getMypageFollowCategoryMakeAction() {
		return mypageFollowCategoryMakeAction;
	}

	public static Action getMypageFollowCategoryModifyAction() {
		return mypageFollowCategoryModifyAction;
	}

	public static Action getMypageFollowCategoryDeleteAction() {
		return mypageFollowCategoryDeleteAction;
	}

	public static Action getMypageFollowViewAction() {
		return mypageFollowViewAction;
	}

	public static Action getMypageFollowAddAction() {
		return mypageFollowAddAction;
	}

	public static Action getMypageFollowDeleteAction() {
		return mypageFollowDeleteAction;
	}

	public static Action getMypageReviewViewAction() {
		return mypageReviewViewAction;
	}

	public static Action getMypageReviewDeleteAction() {
		return mypageReviewDeleteAction;
	}

}