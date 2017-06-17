package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.mypage.action.MypageFollowAddAction;
import com.secondproject.mypage.action.MypageFollowAliasAction;
import com.secondproject.mypage.action.MypageFollowCategoryDeleteAction;
import com.secondproject.mypage.action.MypageFollowCategoryMakeAction;
import com.secondproject.mypage.action.MypageFollowCategoryModifyAction;
import com.secondproject.mypage.action.MypageFollowCategoryOrderChangeAction;
import com.secondproject.mypage.action.MypageFollowCommentAction;
import com.secondproject.mypage.action.MypageFollowDeleteAction;
import com.secondproject.mypage.action.MypageFollowMoveAction;
import com.secondproject.mypage.action.MypageFollowViewAction;
import com.secondproject.mypage.action.MypageReviewDeleteAction;
import com.secondproject.mypage.action.MypageReviewViewAction;

public class MypageFactory {
	private static Action mypageFollowCategoryMakeAction; 
	private static Action mypageFollowCategoryModifyAction; 
	private static Action mypageFollowCategoryDeleteAction; 
	private static Action mypageFollowCategoryOrderChangeAction; 
	private static Action mypageFollowViewAction;
	private static Action mypageFollowAddAction; 
	private static Action mypageFollowDeleteAction; 
	private static Action mypageFollowMoveAction; 
	private static Action mypageFollowAliasAction; 
	private static Action mypageFollowCommentAction; 
	private static Action mypageReviewViewAction; 
	private static Action mypageReviewDeleteAction; 


	static {
		mypageFollowCategoryMakeAction= new MypageFollowCategoryMakeAction();
		mypageFollowCategoryModifyAction= new MypageFollowCategoryModifyAction();
		mypageFollowCategoryDeleteAction= new MypageFollowCategoryDeleteAction();
		mypageFollowCategoryOrderChangeAction= new MypageFollowCategoryOrderChangeAction();
		mypageFollowViewAction= new MypageFollowViewAction();
		mypageFollowAddAction= new MypageFollowAddAction();
		mypageFollowDeleteAction= new MypageFollowDeleteAction();
		mypageFollowMoveAction= new MypageFollowMoveAction();
		mypageFollowAliasAction= new MypageFollowAliasAction();
		mypageFollowCommentAction= new MypageFollowCommentAction();
		mypageReviewViewAction= new MypageReviewViewAction();
		mypageReviewDeleteAction= new MypageReviewDeleteAction();
		
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


	public static Action getMypageFollowCategoryOrderChangeAction() {
		return mypageFollowCategoryOrderChangeAction;
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


	public static Action getMypageFollowMoveAction() {
		return mypageFollowMoveAction;
	}


	public static Action getMypageFollowAliasAction() {
		return mypageFollowAliasAction;
	}


	public static Action getMypageFollowCommentAction() {
		return mypageFollowCommentAction;
	}


	public static Action getMypageReviewViewAction() {
		return mypageReviewViewAction;
	}


	public static Action getMypageReviewDeleteAction() {
		return mypageReviewDeleteAction;
	}
	
	
}