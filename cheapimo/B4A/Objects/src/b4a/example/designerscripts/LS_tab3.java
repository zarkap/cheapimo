package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_tab3{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel3").vw.setLeft((int)(0d));
views.get("panel3").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("panel3").vw.setTop((int)(0d));
views.get("panel3").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("scrollview3").vw.setLeft((int)((1d / 100 * width)));
views.get("scrollview3").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
views.get("scrollview3").vw.setTop((int)((1d / 100 * height)));
views.get("scrollview3").vw.setHeight((int)((99d / 100 * height) - ((1d / 100 * height))));

}
}