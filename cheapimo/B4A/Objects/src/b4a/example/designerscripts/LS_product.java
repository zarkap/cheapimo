package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_product{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setLeft((int)(0d));
views.get("panel1").vw.setWidth((int)((45d / 100 * width) - (0d)));
views.get("panel1").vw.setTop((int)(0d));
views.get("panel1").vw.setHeight((int)(200d - (0d)));
views.get("imageview1").vw.setLeft((int)((1d / 100 * width)));
views.get("imageview1").vw.setWidth((int)((44d / 100 * width) - ((1d / 100 * width))));
views.get("imageview1").vw.setTop((int)((1d / 100 * height)));
views.get("imageview1").vw.setHeight((int)(150d - ((1d / 100 * height))));
views.get("label1").vw.setLeft((int)((1d / 100 * width)));
views.get("label1").vw.setWidth((int)((44d / 100 * width) - ((1d / 100 * width))));
views.get("label1").vw.setTop((int)(151d));
views.get("label1").vw.setHeight((int)(174d - (151d)));
views.get("label2").vw.setLeft((int)((1d / 100 * width)));
views.get("label2").vw.setWidth((int)((44d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 10;BA.debugLine="Label2.SetTopAndBottom(175,199)"[product/General script]
views.get("label2").vw.setTop((int)(175d));
views.get("label2").vw.setHeight((int)(199d - (175d)));

}
}