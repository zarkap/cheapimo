package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_mainpage{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("actoolbarlight1").vw.setLeft((int)(0d));
views.get("actoolbarlight1").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("actoolbarlight1").vw.setTop((int)(0d));
views.get("actoolbarlight1").vw.setHeight((int)((7d / 100 * height) - (0d)));
views.get("tabstrip1").vw.setLeft((int)(0d));
views.get("tabstrip1").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 6;BA.debugLine="TabStrip1.SetTopAndBottom(7%y,100%y)"[MainPage/General script]
views.get("tabstrip1").vw.setTop((int)((7d / 100 * height)));
views.get("tabstrip1").vw.setHeight((int)((100d / 100 * height) - ((7d / 100 * height))));
//BA.debugLineNum = 7;BA.debugLine="Label1.Top=ACToolBarLight1.Bottom"[MainPage/General script]
views.get("label1").vw.setTop((int)((views.get("actoolbarlight1").vw.getTop() + views.get("actoolbarlight1").vw.getHeight())));
//BA.debugLineNum = 8;BA.debugLine="Label1.Height=58"[MainPage/General script]
views.get("label1").vw.setHeight((int)(58d));
//BA.debugLineNum = 9;BA.debugLine="Label1.Left=43%x"[MainPage/General script]
views.get("label1").vw.setLeft((int)((43d / 100 * width)));
//BA.debugLineNum = 10;BA.debugLine="Label1.Width=200"[MainPage/General script]
views.get("label1").vw.setWidth((int)(200d));

}
}