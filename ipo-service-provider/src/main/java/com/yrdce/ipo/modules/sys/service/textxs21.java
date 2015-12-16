package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

public class textxs21 {

	@SuppressWarnings({ "unchecked", "unchecked" })
	public static void main(String[] args) {

		StringBuffer buf = new StringBuffer(
				"a,b,c,d,e,f,g,h,i,g,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
		buf.append(",A,B,C,D,E,F,G,H,I,G,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z");
		buf.append(",~,@,#,$,%,^,&,*,(,),_,+,|,`,.");
		buf.append(",1,2,3,4,5,6,7,8,9,0");

		String[] arr = buf.toString().split(",");
		List pswdList = new ArrayList();

		for (int i = 0; i < 50; i++) {
			pswdList.add(getPswd(arr));
		}

		for (int i = 0; i < pswdList.size(); i++) {
			System.out.println(pswdList.get(i));
		}
	}

	public static String getPswd(String[] arr) {
		StringBuffer b = new StringBuffer();
		java.util.Random r;
		int k;
		for (int i = 0; i < 15; i++) {
			r = new java.util.Random();
			k = r.nextInt();
			b.append(String.valueOf(arr[Math.abs(k % 76)]));
		}

		return b.toString();
	}

}