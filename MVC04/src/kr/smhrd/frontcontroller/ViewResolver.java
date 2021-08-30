package kr.smhrd.frontcontroller;

public class ViewResolver {
	public static String makeUrl(String view) {
		return "/WEB-INF/views/"+view+".jsp"; //--> XML 설정파일
	}
}

//  "/WEB-INF/views/"+view+".jsp" 이거 하는법