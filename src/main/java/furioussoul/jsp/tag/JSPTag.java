package furioussoul.jsp.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class JSPTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = this.pageContext.getOut();
		try {
			writer.print("my tag start");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter writer = this.pageContext.getOut();
		try {
			writer.print("my tag end");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.EVAL_PAGE;
	}
}
