package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class safheasli extends Activity implements B4AActivity{
	public static safheasli mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.safheasli");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (safheasli).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.safheasli");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.safheasli", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (safheasli) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (safheasli) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return safheasli.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (safheasli) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (safheasli) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            safheasli mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (safheasli) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public de.amberhome.objects.appcompat.ACActionBar _toolbarhelper = null;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _actoolbarlight1 = null;
public anywheresoftware.b4a.objects.TabStripViewPager _tabstrip1 = null;
public anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _horizontalscrollview1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview2 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview3 = null;
public b4a.example.b4xdrawer _draw = null;
public static int _arz = 0;
public static float _a1 = 0f;
public static int _tool = 0;
public static float _t1 = 0f;
public b4a.example.main _main = null;
public b4a.example.showproduct _showproduct = null;
public b4a.example.productdetail _productdetail = null;
public b4a.example.slidmenu _slidmenu = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.httputils2service _httputils2service = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.PanelWrapper _listmenu = null;
int _j = 0;
anywheresoftware.b4a.objects.PanelWrapper _hslist = null;
 //BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="draw.Initialize(Me,\"draw\",Activity,40%x)";
mostCurrent._draw._initialize /*String*/ (mostCurrent.activityBA,safheasli.getObject(),"draw",(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject())),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA));
 //BA.debugLineNum = 36;BA.debugLine="draw.CenterPanel.LoadLayout(\"MainPage\")";
mostCurrent._draw._getcenterpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().LoadLayout("MainPage",mostCurrent.activityBA);
 //BA.debugLineNum = 43;BA.debugLine="draw.LeftPanel.LoadLayout(\"drawer\")";
mostCurrent._draw._getleftpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ().LoadLayout("drawer",mostCurrent.activityBA);
 //BA.debugLineNum = 45;BA.debugLine="TabStrip1.LoadLayout(\"tab1\",\"men\")";
mostCurrent._tabstrip1.LoadLayout("tab1",BA.ObjectToCharSequence("men"));
 //BA.debugLineNum = 46;BA.debugLine="TabStrip1.LoadLayout(\"tab2\",\"women\")";
mostCurrent._tabstrip1.LoadLayout("tab2",BA.ObjectToCharSequence("women"));
 //BA.debugLineNum = 47;BA.debugLine="TabStrip1.LoadLayout(\"tab3\",\"set\")";
mostCurrent._tabstrip1.LoadLayout("tab3",BA.ObjectToCharSequence("set"));
 //BA.debugLineNum = 48;BA.debugLine="For i=0 To 4";
{
final int step7 = 1;
final int limit7 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 49;BA.debugLine="Dim listmenu As Panel";
_listmenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 50;BA.debugLine="listmenu.Initialize(\"lmpanel\")";
_listmenu.Initialize(mostCurrent.activityBA,"lmpanel");
 //BA.debugLineNum = 51;BA.debugLine="listmenu.Tag=i";
_listmenu.setTag((Object)(_i));
 //BA.debugLineNum = 52;BA.debugLine="listmenu.LoadLayout(\"list\")";
_listmenu.LoadLayout("list",mostCurrent.activityBA);
 //BA.debugLineNum = 53;BA.debugLine="ScrollView1.Panel.AddView(listmenu,0,tool,100%x,";
mostCurrent._scrollview1.getPanel().AddView((android.view.View)(_listmenu.getObject()),(int) (0),_tool,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (310));
 //BA.debugLineNum = 54;BA.debugLine="ScrollView1.Tag=i";
mostCurrent._scrollview1.setTag((Object)(_i));
 //BA.debugLineNum = 55;BA.debugLine="For j=0 To 4";
{
final int step14 = 1;
final int limit14 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit14 ;_j = _j + step14 ) {
 //BA.debugLineNum = 56;BA.debugLine="Dim hslist As Panel";
_hslist = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="hslist.Initialize(\"hspanel\")";
_hslist.Initialize(mostCurrent.activityBA,"hspanel");
 //BA.debugLineNum = 58;BA.debugLine="hslist.Tag=j";
_hslist.setTag((Object)(_j));
 //BA.debugLineNum = 59;BA.debugLine="hslist.LoadLayout(\"product\")";
_hslist.LoadLayout("product",mostCurrent.activityBA);
 //BA.debugLineNum = 60;BA.debugLine="HorizontalScrollView1.Panel.AddView(hslist,arz,";
mostCurrent._horizontalscrollview1.getPanel().AddView((android.view.View)(_hslist.getObject()),_arz,(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA),(int) (200));
 //BA.debugLineNum = 61;BA.debugLine="HorizontalScrollView1.Tag=j";
mostCurrent._horizontalscrollview1.setTag((Object)(_j));
 //BA.debugLineNum = 62;BA.debugLine="a1=45%x";
_a1 = (float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 63;BA.debugLine="hslist.Width=a1+2%x";
_hslist.setWidth((int) (_a1+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA)));
 //BA.debugLineNum = 64;BA.debugLine="arz=arz+a1+1%x";
_arz = (int) (_arz+_a1+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA));
 }
};
 //BA.debugLineNum = 66;BA.debugLine="HorizontalScrollView1.Panel.Width=arz";
mostCurrent._horizontalscrollview1.getPanel().setWidth(_arz);
 //BA.debugLineNum = 67;BA.debugLine="arz=0";
_arz = (int) (0);
 //BA.debugLineNum = 68;BA.debugLine="t1=250";
_t1 = (float) (250);
 //BA.debugLineNum = 69;BA.debugLine="listmenu.Height=t1 + 2%y";
_listmenu.setHeight((int) (_t1+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA)));
 //BA.debugLineNum = 70;BA.debugLine="tool=tool+t1+1%y";
_tool = (int) (_tool+_t1+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 }
};
 //BA.debugLineNum = 72;BA.debugLine="ScrollView1.Panel.Height=tool";
mostCurrent._scrollview1.getPanel().setHeight(_tool);
 //BA.debugLineNum = 73;BA.debugLine="tool=0";
_tool = (int) (0);
 //BA.debugLineNum = 75;BA.debugLine="For i=0 To 4";
{
final int step33 = 1;
final int limit33 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit33 ;_i = _i + step33 ) {
 //BA.debugLineNum = 76;BA.debugLine="Dim listmenu As Panel";
_listmenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 77;BA.debugLine="listmenu.Initialize(\"lmpanel\")";
_listmenu.Initialize(mostCurrent.activityBA,"lmpanel");
 //BA.debugLineNum = 78;BA.debugLine="listmenu.Tag=i";
_listmenu.setTag((Object)(_i));
 //BA.debugLineNum = 79;BA.debugLine="listmenu.LoadLayout(\"list\")";
_listmenu.LoadLayout("list",mostCurrent.activityBA);
 //BA.debugLineNum = 80;BA.debugLine="ScrollView2.Panel.AddView(listmenu,0,tool,100%x,";
mostCurrent._scrollview2.getPanel().AddView((android.view.View)(_listmenu.getObject()),(int) (0),_tool,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (310));
 //BA.debugLineNum = 81;BA.debugLine="ScrollView2.Tag=i";
mostCurrent._scrollview2.setTag((Object)(_i));
 //BA.debugLineNum = 82;BA.debugLine="For j=0 To 4";
{
final int step40 = 1;
final int limit40 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit40 ;_j = _j + step40 ) {
 //BA.debugLineNum = 83;BA.debugLine="Dim hslist As Panel";
_hslist = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 84;BA.debugLine="hslist.Initialize(\"hspanel\")";
_hslist.Initialize(mostCurrent.activityBA,"hspanel");
 //BA.debugLineNum = 85;BA.debugLine="hslist.Tag=j";
_hslist.setTag((Object)(_j));
 //BA.debugLineNum = 86;BA.debugLine="hslist.LoadLayout(\"product\")";
_hslist.LoadLayout("product",mostCurrent.activityBA);
 //BA.debugLineNum = 87;BA.debugLine="HorizontalScrollView1.Panel.AddView(hslist,arz,";
mostCurrent._horizontalscrollview1.getPanel().AddView((android.view.View)(_hslist.getObject()),_arz,(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA),(int) (200));
 //BA.debugLineNum = 88;BA.debugLine="HorizontalScrollView1.Tag=j";
mostCurrent._horizontalscrollview1.setTag((Object)(_j));
 //BA.debugLineNum = 89;BA.debugLine="a1=45%x";
_a1 = (float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 90;BA.debugLine="hslist.Width=a1+2%x";
_hslist.setWidth((int) (_a1+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA)));
 //BA.debugLineNum = 91;BA.debugLine="arz=arz+a1+1%x";
_arz = (int) (_arz+_a1+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA));
 }
};
 //BA.debugLineNum = 93;BA.debugLine="HorizontalScrollView1.Panel.Width=arz";
mostCurrent._horizontalscrollview1.getPanel().setWidth(_arz);
 //BA.debugLineNum = 94;BA.debugLine="arz=0";
_arz = (int) (0);
 //BA.debugLineNum = 95;BA.debugLine="t1=250";
_t1 = (float) (250);
 //BA.debugLineNum = 96;BA.debugLine="listmenu.Height=t1 + 2%y";
_listmenu.setHeight((int) (_t1+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA)));
 //BA.debugLineNum = 97;BA.debugLine="tool=tool+t1+1%y";
_tool = (int) (_tool+_t1+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 }
};
 //BA.debugLineNum = 99;BA.debugLine="ScrollView2.Panel.Height=tool";
mostCurrent._scrollview2.getPanel().setHeight(_tool);
 //BA.debugLineNum = 100;BA.debugLine="tool=0";
_tool = (int) (0);
 //BA.debugLineNum = 102;BA.debugLine="For i=0 To 4";
{
final int step59 = 1;
final int limit59 = (int) (4);
_i = (int) (0) ;
for (;_i <= limit59 ;_i = _i + step59 ) {
 //BA.debugLineNum = 103;BA.debugLine="Dim listmenu As Panel";
_listmenu = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 104;BA.debugLine="listmenu.Initialize(\"lmpanel\")";
_listmenu.Initialize(mostCurrent.activityBA,"lmpanel");
 //BA.debugLineNum = 105;BA.debugLine="listmenu.Tag=i";
_listmenu.setTag((Object)(_i));
 //BA.debugLineNum = 106;BA.debugLine="listmenu.LoadLayout(\"list\")";
_listmenu.LoadLayout("list",mostCurrent.activityBA);
 //BA.debugLineNum = 107;BA.debugLine="ScrollView3.Panel.AddView(listmenu,0,tool,100%x,";
mostCurrent._scrollview3.getPanel().AddView((android.view.View)(_listmenu.getObject()),(int) (0),_tool,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (310));
 //BA.debugLineNum = 108;BA.debugLine="ScrollView3.Tag=i";
mostCurrent._scrollview3.setTag((Object)(_i));
 //BA.debugLineNum = 109;BA.debugLine="For j=0 To 4";
{
final int step66 = 1;
final int limit66 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit66 ;_j = _j + step66 ) {
 //BA.debugLineNum = 110;BA.debugLine="Dim hslist As Panel";
_hslist = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 111;BA.debugLine="hslist.Initialize(\"hspanel\")";
_hslist.Initialize(mostCurrent.activityBA,"hspanel");
 //BA.debugLineNum = 112;BA.debugLine="hslist.Tag=j";
_hslist.setTag((Object)(_j));
 //BA.debugLineNum = 113;BA.debugLine="hslist.LoadLayout(\"product\")";
_hslist.LoadLayout("product",mostCurrent.activityBA);
 //BA.debugLineNum = 114;BA.debugLine="HorizontalScrollView1.Panel.AddView(hslist,arz,";
mostCurrent._horizontalscrollview1.getPanel().AddView((android.view.View)(_hslist.getObject()),_arz,(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA),(int) (200));
 //BA.debugLineNum = 115;BA.debugLine="HorizontalScrollView1.Tag=j";
mostCurrent._horizontalscrollview1.setTag((Object)(_j));
 //BA.debugLineNum = 116;BA.debugLine="a1=45%x";
_a1 = (float) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (45),mostCurrent.activityBA));
 //BA.debugLineNum = 117;BA.debugLine="hslist.Width=a1+2%x";
_hslist.setWidth((int) (_a1+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (2),mostCurrent.activityBA)));
 //BA.debugLineNum = 118;BA.debugLine="arz=arz+a1+1%x";
_arz = (int) (_arz+_a1+anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA));
 }
};
 //BA.debugLineNum = 120;BA.debugLine="HorizontalScrollView1.Panel.Width=arz";
mostCurrent._horizontalscrollview1.getPanel().setWidth(_arz);
 //BA.debugLineNum = 121;BA.debugLine="arz=0";
_arz = (int) (0);
 //BA.debugLineNum = 122;BA.debugLine="t1=250";
_t1 = (float) (250);
 //BA.debugLineNum = 123;BA.debugLine="listmenu.Height=t1 + 2%y";
_listmenu.setHeight((int) (_t1+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA)));
 //BA.debugLineNum = 124;BA.debugLine="tool=tool+t1+1%y";
_tool = (int) (_tool+_t1+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (1),mostCurrent.activityBA));
 }
};
 //BA.debugLineNum = 126;BA.debugLine="ScrollView3.Panel.Height=tool";
mostCurrent._scrollview3.getPanel().setHeight(_tool);
 //BA.debugLineNum = 127;BA.debugLine="tool=0";
_tool = (int) (0);
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 143;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And draw.LeftO";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._draw._getleftopen /*boolean*/ ()) { 
 //BA.debugLineNum = 144;BA.debugLine="draw.LeftOpen = False";
mostCurrent._draw._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 145;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 147;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 130;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _actoolbarlight1_navigationitemclick() throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Sub ACToolBarLight1_NavigationItemClick";
 //BA.debugLineNum = 139;BA.debugLine="draw.LeftOpen = Not(draw.LeftOpen)";
mostCurrent._draw._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.Not(mostCurrent._draw._getleftopen /*boolean*/ ()));
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim toolbarhelper As ACActionBar";
mostCurrent._toolbarhelper = new de.amberhome.objects.appcompat.ACActionBar();
 //BA.debugLineNum = 17;BA.debugLine="Private ACToolBarLight1 As ACToolBarLight";
mostCurrent._actoolbarlight1 = new de.amberhome.objects.appcompat.ACToolbarLightWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private TabStrip1 As TabStrip";
mostCurrent._tabstrip1 = new anywheresoftware.b4a.objects.TabStripViewPager();
 //BA.debugLineNum = 19;BA.debugLine="Private HorizontalScrollView1 As HorizontalScroll";
mostCurrent._horizontalscrollview1 = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private ScrollView1 As ScrollView";
mostCurrent._scrollview1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private ScrollView2 As ScrollView";
mostCurrent._scrollview2 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private ScrollView3 As ScrollView";
mostCurrent._scrollview3 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim draw As B4XDrawer";
mostCurrent._draw = new b4a.example.b4xdrawer();
 //BA.debugLineNum = 25;BA.debugLine="Dim arz As Int";
_arz = 0;
 //BA.debugLineNum = 26;BA.debugLine="Dim a1 As Float";
_a1 = 0f;
 //BA.debugLineNum = 27;BA.debugLine="Dim tool As Int";
_tool = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim t1 As Float";
_t1 = 0f;
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _label1_click() throws Exception{
 //BA.debugLineNum = 150;BA.debugLine="Private Sub Label1_Click";
 //BA.debugLineNum = 151;BA.debugLine="Draw.LeftOpen = Not(Draw.LeftOpen)";
mostCurrent._draw._setleftopen /*boolean*/ (anywheresoftware.b4a.keywords.Common.Not(mostCurrent._draw._getleftopen /*boolean*/ ()));
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
