package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_detail{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[detail/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="Panel1.SetLeftAndRight(0,100%x)"[detail/General script]
views.get("panel1").vw.setLeft((int)(0d));
views.get("panel1").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 4;BA.debugLine="Panel1.SetTopAndBottom(0,7%y)"[detail/General script]
views.get("panel1").vw.setTop((int)(0d));
views.get("panel1").vw.setHeight((int)((7d / 100 * height) - (0d)));
//BA.debugLineNum = 5;BA.debugLine="Panel2.SetLeftAndRight(0,100%x)"[detail/General script]
views.get("panel2").vw.setLeft((int)(0d));
views.get("panel2").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 6;BA.debugLine="Panel2.SetTopAndBottom(Panel1.Bottom,100%y)"[detail/General script]
views.get("panel2").vw.setTop((int)((views.get("panel1").vw.getTop() + views.get("panel1").vw.getHeight())));
views.get("panel2").vw.setHeight((int)((100d / 100 * height) - ((views.get("panel1").vw.getTop() + views.get("panel1").vw.getHeight()))));

}
}