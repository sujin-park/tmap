package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.mypage.action.MypageFollowAddAction;
import com.secondproject.mypage.action.MypageFollowCategoryDeleteAction;
import com.secondproject.mypage.action.MypageFollowCategoryDownOrderAction;
import com.secondproject.mypage.action.MypageFollowCategoryListViewAction;
import com.secondproject.mypage.action.MypageFollowCategoryMakeAction;
import com.secondproject.mypage.action.MypageFollowCategoryModifyAction;
import com.secondproject.mypage.action.MypageFollowCategoryUpOrderAction;
import com.secondproject.mypage.action.MypageFollowDeleteAction;
import com.secondproject.mypage.action.MypageFollowModifyAction;
import com.secondproject.mypage.action.MypageFollowViewAction;
import com.secondproject.mypage.action.MypageReviewDeleteAction;
import com.secondproject.mypage.action.MypageReviewViewAction;

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
	private static Action mypageReviewViewAction;
	private static Action mypageReviewDeleteAction;

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
		mypageReviewViewAction = new MypageReviewViewAction();
		mypageReviewDeleteAction = new MypageReviewDeleteAction();

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