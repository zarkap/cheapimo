package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xpagesmanager extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.b4xpagesmanager");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.b4xpagesmanager.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.example.b4xorderedmap _idtob4xpage = null;
public b4a.example.b4xorderedmap _rootb4xtopage = null;
public anywheresoftware.b4j.object.JavaObject _context = null;
public b4a.example.b4xset _mstackofpageids = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.ActivityWrapper _mmainform = null;
public boolean _showupindicator = false;
public anywheresoftware.b4j.object.JavaObject _actionbar = null;
public boolean _isforeground = false;
public int _transitionanimationduration = 0;
public b4a.example.b4xmainpage _mainpage = null;
public String _stackstring = "";
public boolean _logevents = false;
public b4a.example.main _main = null;
public b4a.example.safheasli _safheasli = null;
public b4a.example.showproduct _showproduct = null;
public b4a.example.productdetail _productdetail = null;
public b4a.example.slidmenu _slidmenu = null;
public b4a.example.starter _starter = null;
public b4a.example.b4xpages _b4xpages = null;
public b4a.example.b4xcollections _b4xcollections = null;
public b4a.example.httputils2service _httputils2service = null;
public static class _b4xpageparent{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.ActivityWrapper NativeType;
public anywheresoftware.b4a.objects.collections.List MenuItems;
public void Initialize() {
IsInitialized = true;
NativeType = new anywheresoftware.b4a.objects.ActivityWrapper();
MenuItems = new anywheresoftware.b4a.objects.collections.List();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _b4amenuitem{
public boolean IsInitialized;
public Object Title;
public anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper Bitmap;
public String Tag;
public boolean AddToBar;
public anywheresoftware.b4j.object.JavaObject NativeMenuItem;
public void Initialize() {
IsInitialized = true;
Title = new Object();
Bitmap = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
Tag = "";
AddToBar = false;
NativeMenuItem = new anywheresoftware.b4j.object.JavaObject();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _b4xpageinfo{
public boolean IsInitialized;
public Object B4XPage;
public String Id;
public boolean Created;
public Object Title;
public anywheresoftware.b4a.objects.B4XViewWrapper Root;
public boolean IsFirst;
public b4a.example.b4xpagesmanager._b4xpageparent Parent;
public void Initialize() {
IsInitialized = true;
B4XPage = new Object();
Id = "";
Created = false;
Title = new Object();
Root = new anywheresoftware.b4a.objects.B4XViewWrapper();
IsFirst = false;
Parent = new b4a.example.b4xpagesmanager._b4xpageparent();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _activity_actionbarhomeclick() throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 106;BA.debugLine="Public Sub Activity_ActionBarHomeClick";
 //BA.debugLineNum = 107;BA.debugLine="Dim pi As B4XPageInfo = GetTopPage";
_pi = _gettoppage();
 //BA.debugLineNum = 108;BA.debugLine="If pi <> Null Then";
if (_pi!= null) { 
 //BA.debugLineNum = 109;BA.debugLine="If CloseRequestExists (pi) Then";
if (_closerequestexists(_pi)) { 
 //BA.debugLineNum = 110;BA.debugLine="HandleCloseRequest(pi)";
_handlecloserequest(_pi);
 }else {
 //BA.debugLineNum = 112;BA.debugLine="ClosePage(pi.B4XPage)";
_closepage(_pi.B4XPage /*Object*/ );
 };
 };
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public boolean  _activity_keypress(int _keycode) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 441;BA.debugLine="Public Sub Activity_KeyPress (KeyCode As Int) As B";
 //BA.debugLineNum = 442;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==__c.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 443;BA.debugLine="Dim pi As B4XPageInfo = GetTopPage";
_pi = _gettoppage();
 //BA.debugLineNum = 444;BA.debugLine="If CloseRequestExists(pi) Then";
if (_closerequestexists(_pi)) { 
 //BA.debugLineNum = 445;BA.debugLine="HandleCloseRequest(pi)";
_handlecloserequest(_pi);
 }else {
 //BA.debugLineNum = 447;BA.debugLine="ClosePage(pi.B4XPage)";
_closepage(_pi.B4XPage /*Object*/ );
 };
 //BA.debugLineNum = 449;BA.debugLine="Return True";
if (true) return __c.True;
 };
 //BA.debugLineNum = 451;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 452;BA.debugLine="End Sub";
return false;
}
public String  _activity_pause() throws Exception{
 //BA.debugLineNum = 608;BA.debugLine="Public Sub Activity_Pause";
 //BA.debugLineNum = 609;BA.debugLine="RaiseEventWithResult(GetTopPage, \"B4XPage_Disappe";
_raiseeventwithresult(_gettoppage(),"B4XPage_Disappear",(Object[])(__c.Null));
 //BA.debugLineNum = 610;BA.debugLine="BackgroundStateChanged(False)";
_backgroundstatechanged(__c.False);
 //BA.debugLineNum = 611;BA.debugLine="End Sub";
return "";
}
public String  _activity_resume() throws Exception{
boolean _shouldraise = false;
 //BA.debugLineNum = 583;BA.debugLine="Public Sub Activity_Resume";
 //BA.debugLineNum = 584;BA.debugLine="Dim ShouldRaise As Boolean = IsForeground = False";
_shouldraise = _isforeground==__c.False;
 //BA.debugLineNum = 585;BA.debugLine="BackgroundStateChanged(True)";
_backgroundstatechanged(__c.True);
 //BA.debugLineNum = 586;BA.debugLine="If ShouldRaise Then";
if (_shouldraise) { 
 //BA.debugLineNum = 587;BA.debugLine="RaiseEvent(GetTopPage, \"B4XPage_Appear\", Null)";
_raiseevent(_gettoppage(),"B4XPage_Appear",(Object[])(__c.Null));
 };
 //BA.debugLineNum = 589;BA.debugLine="End Sub";
return "";
}
public b4a.example.b4xpagesmanager._b4amenuitem  _addmenuitem(Object _b4xpage,Object _title) throws Exception{
b4a.example.b4xpagesmanager._b4amenuitem _mi = null;
 //BA.debugLineNum = 454;BA.debugLine="Public Sub AddMenuItem (B4XPage As Object, Title A";
 //BA.debugLineNum = 455;BA.debugLine="Dim mi As B4AMenuItem";
_mi = new b4a.example.b4xpagesmanager._b4amenuitem();
 //BA.debugLineNum = 456;BA.debugLine="mi.Initialize";
_mi.Initialize();
 //BA.debugLineNum = 457;BA.debugLine="mi.Title = Title";
_mi.Title /*Object*/  = _title;
 //BA.debugLineNum = 458;BA.debugLine="mi.Tag = Title";
_mi.Tag /*String*/  = BA.ObjectToString(_title);
 //BA.debugLineNum = 459;BA.debugLine="FindPIFromB4XPage(B4XPage).Parent.MenuItems.Add(m";
_findpifromb4xpage(_b4xpage).Parent /*b4a.example.b4xpagesmanager._b4xpageparent*/ .MenuItems /*anywheresoftware.b4a.objects.collections.List*/ .Add((Object)(_mi));
 //BA.debugLineNum = 460;BA.debugLine="Return mi";
if (true) return _mi;
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
return null;
}
public String  _addpage(String _id,Object _b4xpage) throws Exception{
String _idtolower = "";
 //BA.debugLineNum = 118;BA.debugLine="Public Sub AddPage (Id As String, B4XPage As Objec";
 //BA.debugLineNum = 119;BA.debugLine="Dim IdToLower As String = Id.ToLowerCase";
_idtolower = _id.toLowerCase();
 //BA.debugLineNum = 120;BA.debugLine="If IdToB4XPage.ContainsKey(IdToLower) Then";
if (_idtob4xpage._containskey /*boolean*/ ((Object)(_idtolower))) { 
 //BA.debugLineNum = 121;BA.debugLine="Log($\"Page with this id already exists: ${IdToLo";
__c.LogImpl("97995395",("Page with this id already exists: "+__c.SmartStringFormatter("",(Object)(_idtolower))+"!"),0);
 //BA.debugLineNum = 122;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 124;BA.debugLine="IdToB4XPage.Put(IdToLower, CreateB4XPageInfo(B4XP";
_idtob4xpage._put /*String*/ ((Object)(_idtolower),(Object)(_createb4xpageinfo(_b4xpage,_idtolower,__c.False,(Object)(_id))));
 //BA.debugLineNum = 125;BA.debugLine="If IdToB4XPage.Size = 1 Then ShowPage(IdToLower)";
if (_idtob4xpage._getsize /*int*/ ()==1) { 
_showpage(_idtolower);};
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _addpageandcreate(String _id,Object _b4xpage) throws Exception{
 //BA.debugLineNum = 128;BA.debugLine="Public Sub AddPageAndCreate (Id As String, B4XPage";
 //BA.debugLineNum = 129;BA.debugLine="AddPage (Id, B4XPage)";
_addpage(_id,_b4xpage);
 //BA.debugLineNum = 130;BA.debugLine="CreatePageIfNeeded(GetPageFromId(Id))";
_createpageifneeded(_getpagefromid(_id));
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public String  _backgroundstatechanged(boolean _newstate) throws Exception{
String _ev = "";
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 591;BA.debugLine="Private Sub BackgroundStateChanged (NewState As Bo";
 //BA.debugLineNum = 592;BA.debugLine="If IsForeground = NewState Then Return";
if (_isforeground==_newstate) { 
if (true) return "";};
 //BA.debugLineNum = 593;BA.debugLine="IsForeground = NewState";
_isforeground = _newstate;
 //BA.debugLineNum = 594;BA.debugLine="Dim ev As String";
_ev = "";
 //BA.debugLineNum = 595;BA.debugLine="If IsForeground Then ev = \"B4XPage_Foreground\" El";
if (_isforeground) { 
_ev = "B4XPage_Foreground";}
else {
_ev = "B4XPage_Background";};
 //BA.debugLineNum = 596;BA.debugLine="For Each pi As B4XPageInfo In IdToB4XPage.Values";
{
final anywheresoftware.b4a.BA.IterableList group5 = _idtob4xpage._getvalues /*anywheresoftware.b4a.objects.collections.List*/ ();
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_pi = (b4a.example.b4xpagesmanager._b4xpageinfo)(group5.Get(index5));
 //BA.debugLineNum = 597;BA.debugLine="If xui.SubExists(pi.B4XPage, ev, 0) Then";
if (_xui.SubExists(ba,_pi.B4XPage /*Object*/ ,_ev,(int) (0))) { 
 //BA.debugLineNum = 598;BA.debugLine="LogEvent(pi, ev)";
_logevent(_pi,_ev);
 //BA.debugLineNum = 599;BA.debugLine="If IsForeground Then";
if (_isforeground) { 
 //BA.debugLineNum = 600;BA.debugLine="CallSubDelayed(pi.B4XPage, ev)";
__c.CallSubDelayed(ba,_pi.B4XPage /*Object*/ ,_ev);
 }else {
 //BA.debugLineNum = 602;BA.debugLine="CallSub(pi.B4XPage, ev)";
__c.CallSubNew(ba,_pi.B4XPage /*Object*/ ,_ev);
 };
 };
 }
};
 //BA.debugLineNum = 606;BA.debugLine="End Sub";
return "";
}
public String  _checkmainactivityorientations() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _pi = null;
Object[] _activities = null;
anywheresoftware.b4j.object.JavaObject _act = null;
String _name = "";
int _screenorientation = 0;
 //BA.debugLineNum = 88;BA.debugLine="Private Sub CheckMainActivityOrientations";
 //BA.debugLineNum = 90;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 91;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(ba);
 //BA.debugLineNum = 92;BA.debugLine="ActionBar = jo.RunMethod(\"getActionBar\", Null)";
_actionbar = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("getActionBar",(Object[])(__c.Null))));
 //BA.debugLineNum = 93;BA.debugLine="Dim pi As JavaObject = jo.RunMethodJO(\"getPackage";
_pi = new anywheresoftware.b4j.object.JavaObject();
_pi = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethodJO("getPackageManager",(Object[])(__c.Null)).RunMethod("getPackageInfo",new Object[]{(Object)(__c.Application.getPackageName()),(Object)(1)})));
 //BA.debugLineNum = 94;BA.debugLine="Dim activities() As Object = pi.GetField(\"activit";
_activities = (Object[])(_pi.GetField("activities"));
 //BA.debugLineNum = 95;BA.debugLine="For Each Act As JavaObject In activities";
_act = new anywheresoftware.b4j.object.JavaObject();
{
final Object[] group6 = _activities;
final int groupLen6 = group6.length
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_act = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(group6[index6]));
 //BA.debugLineNum = 96;BA.debugLine="Dim name As String = Act.GetField(\"name\")";
_name = BA.ObjectToString(_act.GetField("name"));
 //BA.debugLineNum = 97;BA.debugLine="If name.EndsWith(\".main\") Then";
if (_name.endsWith(".main")) { 
 //BA.debugLineNum = 98;BA.debugLine="Dim screenOrientation As Int = Act.GetField(\"sc";
_screenorientation = (int)(BA.ObjectToNumber(_act.GetField("screenOrientation")));
 //BA.debugLineNum = 99;BA.debugLine="If screenOrientation = -1 Then";
if (_screenorientation==-1) { 
 //BA.debugLineNum = 100;BA.debugLine="LogColor(\"#SupportedOrientations attribute mus";
__c.LogImpl("97864332","#SupportedOrientations attribute must be set to landscape or portrait.",_xui.Color_Red);
 };
 };
 }
};
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 23;BA.debugLine="Private IdToB4XPage As B4XOrderedMap";
_idtob4xpage = new b4a.example.b4xorderedmap();
 //BA.debugLineNum = 24;BA.debugLine="Private RootB4XToPage As B4XOrderedMap";
_rootb4xtopage = new b4a.example.b4xorderedmap();
 //BA.debugLineNum = 26;BA.debugLine="Private Context As JavaObject";
_context = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 27;BA.debugLine="Type B4XPageParent (NativeType As Activity, MenuI";
;
 //BA.debugLineNum = 28;BA.debugLine="Type B4AMenuItem (Title As Object, Bitmap As B4XB";
;
 //BA.debugLineNum = 34;BA.debugLine="Type B4XPageInfo (B4XPage As Object, Id As String";
;
 //BA.debugLineNum = 38;BA.debugLine="Public mStackOfPageIds As B4XSet";
_mstackofpageids = new b4a.example.b4xset();
 //BA.debugLineNum = 39;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 43;BA.debugLine="Private mMainForm As Activity";
_mmainform = new anywheresoftware.b4a.objects.ActivityWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Public ShowUpIndicator As Boolean = True";
_showupindicator = __c.True;
 //BA.debugLineNum = 45;BA.debugLine="Public ActionBar As JavaObject";
_actionbar = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 49;BA.debugLine="Public IsForeground As Boolean";
_isforeground = false;
 //BA.debugLineNum = 50;BA.debugLine="Public TransitionAnimationDuration As Int = 100";
_transitionanimationduration = (int) (100);
 //BA.debugLineNum = 51;BA.debugLine="Public MainPage As B4XMainPage";
_mainpage = new b4a.example.b4xmainpage();
 //BA.debugLineNum = 52;BA.debugLine="Private StackString As String";
_stackstring = "";
 //BA.debugLineNum = 53;BA.debugLine="Public LogEvents as Boolean = False";
_logevents = __c.False;
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _closepage(Object _b4xpage) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 186;BA.debugLine="Public Sub ClosePage (B4XPage As Object)";
 //BA.debugLineNum = 187;BA.debugLine="Dim pi As B4XPageInfo = FindPIFromB4XPage(B4XPage";
_pi = _findpifromb4xpage(_b4xpage);
 //BA.debugLineNum = 188;BA.debugLine="If mStackOfPageIds.Contains(pi.Id) = False Then R";
if (_mstackofpageids._contains /*boolean*/ ((Object)(_pi.Id /*String*/ ))==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 189;BA.debugLine="If xui.IsB4i And GetTopPage <> pi Then";
if (_xui.getIsB4i() && (_gettoppage()).equals(_pi) == false) { 
 //BA.debugLineNum = 190;BA.debugLine="Log(\"Only top page can be closed\")";
__c.LogImpl("98257540","Only top page can be closed",0);
 //BA.debugLineNum = 191;BA.debugLine="Return";
if (true) return "";
 }else if(_xui.getIsB4i() && _mstackofpageids._getsize /*int*/ ()==1) { 
 //BA.debugLineNum = 193;BA.debugLine="Log(\"First page cannot be closed\")";
__c.LogImpl("98257543","First page cannot be closed",0);
 //BA.debugLineNum = 194;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 196;BA.debugLine="ClosePageImpl(pi)";
_closepageimpl(_pi);
 //BA.debugLineNum = 197;BA.debugLine="If GetTopPage = pi Then";
if ((_gettoppage()).equals(_pi)) { 
 //BA.debugLineNum = 198;BA.debugLine="TopPageDisappear";
_toppagedisappear();
 };
 //BA.debugLineNum = 200;BA.debugLine="If xui.IsB4A And mStackOfPageIds.Size = 1 Then Re";
if (_xui.getIsB4A() && _mstackofpageids._getsize /*int*/ ()==1) { 
if (true) return "";};
 //BA.debugLineNum = 201;BA.debugLine="mStackOfPageIds.Remove(pi.Id)";
_mstackofpageids._remove /*String*/ ((Object)(_pi.Id /*String*/ ));
 //BA.debugLineNum = 202;BA.debugLine="If xui.IsB4A Then ShowPageImpl(GetTopPage)";
if (_xui.getIsB4A()) { 
_showpageimpl(_gettoppage());};
 //BA.debugLineNum = 203;BA.debugLine="TopPageAppear";
_toppageappear();
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return "";
}
public String  _closepageimpl(b4a.example.b4xpagesmanager._b4xpageinfo _pi) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
 //BA.debugLineNum = 289;BA.debugLine="Private Sub ClosePageImpl (pi As B4XPageInfo) 'ign";
 //BA.debugLineNum = 291;BA.debugLine="If mStackOfPageIds.Size = 1 Then";
if (_mstackofpageids._getsize /*int*/ ()==1) { 
 //BA.debugLineNum = 292;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 293;BA.debugLine="i.Initialize(i.ACTION_MAIN, \"\")";
_i.Initialize(_i.ACTION_MAIN,"");
 //BA.debugLineNum = 294;BA.debugLine="i.AddCategory(\"android.intent.category.HOME\")";
_i.AddCategory("android.intent.category.HOME");
 //BA.debugLineNum = 295;BA.debugLine="i.Flags = 0x10000000";
_i.setFlags((int) (0x10000000));
 //BA.debugLineNum = 296;BA.debugLine="StartActivity(i)";
__c.StartActivity(ba,(Object)(_i.getObject()));
 }else {
 //BA.debugLineNum = 298;BA.debugLine="pi.Root.RemoveViewFromParent";
_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .RemoveViewFromParent();
 };
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
return "";
}
public boolean  _closerequestexists(b4a.example.b4xpagesmanager._b4xpageinfo _pi) throws Exception{
 //BA.debugLineNum = 507;BA.debugLine="Private Sub CloseRequestExists (pi As B4XPageInfo)";
 //BA.debugLineNum = 508;BA.debugLine="Return xui.SubExists(pi.B4XPage, \"B4XPage_CloseRe";
if (true) return _xui.SubExists(ba,_pi.B4XPage /*Object*/ ,"B4XPage_CloseRequest",(int) (0));
 //BA.debugLineNum = 509;BA.debugLine="End Sub";
return false;
}
public b4a.example.b4xpagesmanager._b4xpageinfo  _createb4xpageinfo(Object _b4xpage,String _id,boolean _created,Object _title) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _t1 = null;
 //BA.debugLineNum = 393;BA.debugLine="Private Sub CreateB4XPageInfo (B4XPage As Object,";
 //BA.debugLineNum = 394;BA.debugLine="Dim t1 As B4XPageInfo";
_t1 = new b4a.example.b4xpagesmanager._b4xpageinfo();
 //BA.debugLineNum = 395;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 396;BA.debugLine="t1.B4XPage = B4XPage";
_t1.B4XPage /*Object*/  = _b4xpage;
 //BA.debugLineNum = 397;BA.debugLine="t1.Id = Id";
_t1.Id /*String*/  = _id;
 //BA.debugLineNum = 398;BA.debugLine="t1.Created = Created";
_t1.Created /*boolean*/  = _created;
 //BA.debugLineNum = 399;BA.debugLine="t1.Title = Title";
_t1.Title /*Object*/  = _title;
 //BA.debugLineNum = 400;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 401;BA.debugLine="End Sub";
return null;
}
public b4a.example.b4xpagesmanager._b4xpageparent  _createb4xpageparent(Object _nativetype) throws Exception{
b4a.example.b4xpagesmanager._b4xpageparent _t1 = null;
 //BA.debugLineNum = 571;BA.debugLine="Private Sub CreateB4XPageParent (NativeType As Obj";
 //BA.debugLineNum = 577;BA.debugLine="Dim t1 As B4XPageParent";
_t1 = new b4a.example.b4xpagesmanager._b4xpageparent();
 //BA.debugLineNum = 578;BA.debugLine="t1.Initialize";
_t1.Initialize();
 //BA.debugLineNum = 579;BA.debugLine="t1.NativeType = NativeType";
_t1.NativeType /*anywheresoftware.b4a.objects.ActivityWrapper*/  = (anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_nativetype));
 //BA.debugLineNum = 580;BA.debugLine="Return t1";
if (true) return _t1;
 //BA.debugLineNum = 581;BA.debugLine="End Sub";
return null;
}
public String  _createmenu(Object _menu) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
b4a.example.b4xpagesmanager._b4amenuitem _mi = null;
anywheresoftware.b4j.object.JavaObject _nativemenuitem = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
anywheresoftware.b4j.object.JavaObject _listener = null;
 //BA.debugLineNum = 467;BA.debugLine="Public Sub CreateMenu (Menu As Object)";
 //BA.debugLineNum = 468;BA.debugLine="Dim pi As B4XPageInfo = GetTopPage";
_pi = _gettoppage();
 //BA.debugLineNum = 469;BA.debugLine="If pi = Null Then Return";
if (_pi== null) { 
if (true) return "";};
 //BA.debugLineNum = 470;BA.debugLine="Dim jo As JavaObject = Menu";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_menu));
 //BA.debugLineNum = 471;BA.debugLine="For Each mi As B4AMenuItem In pi.Parent.MenuItems";
{
final anywheresoftware.b4a.BA.IterableList group4 = _pi.Parent /*b4a.example.b4xpagesmanager._b4xpageparent*/ .MenuItems /*anywheresoftware.b4a.objects.collections.List*/ ;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_mi = (b4a.example.b4xpagesmanager._b4amenuitem)(group4.Get(index4));
 //BA.debugLineNum = 472;BA.debugLine="Dim NativeMenuItem As JavaObject = jo.RunMethod(";
_nativemenuitem = new anywheresoftware.b4j.object.JavaObject();
_nativemenuitem = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_jo.RunMethod("add",new Object[]{_mi.Title /*Object*/ })));
 //BA.debugLineNum = 473;BA.debugLine="If mi.Bitmap.IsInitialized Then";
if (_mi.Bitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ .IsInitialized()) { 
 //BA.debugLineNum = 474;BA.debugLine="Dim bd As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 475;BA.debugLine="bd.Initialize(mi.Bitmap)";
_bd.Initialize((android.graphics.Bitmap)(_mi.Bitmap /*anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper*/ .getObject()));
 //BA.debugLineNum = 476;BA.debugLine="NativeMenuItem.RunMethod(\"setIcon\", Array(bd))";
_nativemenuitem.RunMethod("setIcon",new Object[]{(Object)(_bd.getObject())});
 };
 //BA.debugLineNum = 478;BA.debugLine="If mi.AddToBar Then";
if (_mi.AddToBar /*boolean*/ ) { 
 //BA.debugLineNum = 479;BA.debugLine="NativeMenuItem.RunMethod(\"setShowAsAction\", Arr";
_nativemenuitem.RunMethod("setShowAsAction",new Object[]{(Object)(1)});
 };
 //BA.debugLineNum = 481;BA.debugLine="Dim listener As JavaObject";
_listener = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 482;BA.debugLine="listener.InitializeNewInstance(Application.Packa";
_listener.InitializeNewInstance(__c.Application.getPackageName()+".b4xpagesmanager$PagesMenuListener",new Object[]{_pi.B4XPage /*Object*/ ,(Object)(_mi.Tag /*String*/ )});
 //BA.debugLineNum = 483;BA.debugLine="NativeMenuItem.RunMethod(\"setOnMenuItemClickList";
_nativemenuitem.RunMethod("setOnMenuItemClickListener",new Object[]{(Object)(_listener.getObject())});
 }
};
 //BA.debugLineNum = 485;BA.debugLine="End Sub";
return "";
}
public String  _createpageifneeded(b4a.example.b4xpagesmanager._b4xpageinfo _pi) throws Exception{
 //BA.debugLineNum = 326;BA.debugLine="Private Sub CreatePageIfNeeded(pi As B4XPageInfo)";
 //BA.debugLineNum = 327;BA.debugLine="If pi.Created Then Return";
if (_pi.Created /*boolean*/ ) { 
if (true) return "";};
 //BA.debugLineNum = 328;BA.debugLine="pi.IsFirst = IdToB4XPage.Size = 1";
_pi.IsFirst /*boolean*/  = _idtob4xpage._getsize /*int*/ ()==1;
 //BA.debugLineNum = 329;BA.debugLine="CreatePageImpl (pi)";
_createpageimpl(_pi);
 //BA.debugLineNum = 330;BA.debugLine="pi.Created = True";
_pi.Created /*boolean*/  = __c.True;
 //BA.debugLineNum = 331;BA.debugLine="RootB4XToPage.Put(pi.Root, pi)";
_rootb4xtopage._put /*String*/ ((Object)(_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(Object)(_pi));
 //BA.debugLineNum = 332;BA.debugLine="CallSub2(pi.B4XPage, \"B4XPage_Created\", pi.root)";
__c.CallSubNew2(ba,_pi.B4XPage /*Object*/ ,"B4XPage_Created",(Object)(_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ ));
 //BA.debugLineNum = 334;BA.debugLine="End Sub";
return "";
}
public String  _createpageimpl(b4a.example.b4xpagesmanager._b4xpageinfo _pi) throws Exception{
 //BA.debugLineNum = 342;BA.debugLine="Private Sub CreatePageImpl (pi As B4XPageInfo)";
 //BA.debugLineNum = 354;BA.debugLine="pi.Root = xui.CreatePanel(\"root\")";
_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _xui.CreatePanel(ba,"root");
 //BA.debugLineNum = 355;BA.debugLine="pi.root.SetLayoutAnimated(0, 0, 0, 100%x, 100%y)";
_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (100),ba));
 //BA.debugLineNum = 356;BA.debugLine="pi.Parent = CreateB4XPageParent(mMainForm)";
_pi.Parent /*b4a.example.b4xpagesmanager._b4xpageparent*/  = _createb4xpageparent((Object)(_mmainform.getObject()));
 //BA.debugLineNum = 357;BA.debugLine="pi.Parent.MenuItems.Initialize";
_pi.Parent /*b4a.example.b4xpagesmanager._b4xpageparent*/ .MenuItems /*anywheresoftware.b4a.objects.collections.List*/ .Initialize();
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public b4a.example.b4xpagesmanager._b4xpageinfo  _findpifromb4xpage(Object _page) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 280;BA.debugLine="Public Sub FindPIFromB4XPage (Page As Object) As B";
 //BA.debugLineNum = 281;BA.debugLine="For Each pi As B4XPageInfo In IdToB4XPage.Values";
{
final anywheresoftware.b4a.BA.IterableList group1 = _idtob4xpage._getvalues /*anywheresoftware.b4a.objects.collections.List*/ ();
final int groupLen1 = group1.getSize()
;int index1 = 0;
;
for (; index1 < groupLen1;index1++){
_pi = (b4a.example.b4xpagesmanager._b4xpageinfo)(group1.Get(index1));
 //BA.debugLineNum = 282;BA.debugLine="If pi.B4XPage = Page Then";
if ((_pi.B4XPage /*Object*/ ).equals(_page)) { 
 //BA.debugLineNum = 283;BA.debugLine="Return pi";
if (true) return _pi;
 };
 }
};
 //BA.debugLineNum = 286;BA.debugLine="Return Null";
if (true) return (b4a.example.b4xpagesmanager._b4xpageinfo)(__c.Null);
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return null;
}
public Object  _getpage(String _id) throws Exception{
 //BA.debugLineNum = 367;BA.debugLine="Public Sub GetPage (Id As String) As Object";
 //BA.debugLineNum = 368;BA.debugLine="Return GetPageFromId(Id).B4XPage";
if (true) return _getpagefromid(_id).B4XPage /*Object*/ ;
 //BA.debugLineNum = 369;BA.debugLine="End Sub";
return null;
}
public b4a.example.b4xpagesmanager._b4xpageinfo  _getpagefromid(String _id) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 371;BA.debugLine="Private Sub GetPageFromId (id As String) As B4XPag";
 //BA.debugLineNum = 372;BA.debugLine="Dim pi As B4XPageInfo = IdToB4XPage.Get(id.ToLowe";
_pi = (b4a.example.b4xpagesmanager._b4xpageinfo)(_idtob4xpage._get /*Object*/ ((Object)(_id.toLowerCase())));
 //BA.debugLineNum = 373;BA.debugLine="If pi = Null Then";
if (_pi== null) { 
 //BA.debugLineNum = 374;BA.debugLine="Log(\"Error: page id not found: \" & id)";
__c.LogImpl("98912899","Error: page id not found: "+_id,0);
 //BA.debugLineNum = 375;BA.debugLine="Log(\"Ids: \" & IdToB4XPage.Keys) 'ignore";
__c.LogImpl("98912900","Ids: "+BA.ObjectToString(_idtob4xpage._getkeys /*anywheresoftware.b4a.objects.collections.List*/ ()),0);
 };
 //BA.debugLineNum = 377;BA.debugLine="Return pi";
if (true) return _pi;
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return null;
}
public b4a.example.b4xpagesmanager._b4xpageinfo  _getpageinfofromroot(anywheresoftware.b4a.objects.B4XViewWrapper _root) throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Public Sub GetPageInfoFromRoot (Root As B4XView) A";
 //BA.debugLineNum = 381;BA.debugLine="Return RootB4XToPage.Get(Root)";
if (true) return (b4a.example.b4xpagesmanager._b4xpageinfo)(_rootb4xtopage._get /*Object*/ ((Object)(_root.getObject())));
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return null;
}
public b4a.example.b4xpagesmanager._b4xpageinfo  _gettoppage() throws Exception{
 //BA.debugLineNum = 565;BA.debugLine="Public Sub GetTopPage As B4XPageInfo";
 //BA.debugLineNum = 566;BA.debugLine="If mStackOfPageIds.Size = 0 Then Return Null";
if (_mstackofpageids._getsize /*int*/ ()==0) { 
if (true) return (b4a.example.b4xpagesmanager._b4xpageinfo)(__c.Null);};
 //BA.debugLineNum = 567;BA.debugLine="Return IdToB4XPage.Get(mStackOfPageIds.AsList.Get";
if (true) return (b4a.example.b4xpagesmanager._b4xpageinfo)(_idtob4xpage._get /*Object*/ (_mstackofpageids._aslist /*anywheresoftware.b4a.objects.collections.List*/ ().Get((int) (_mstackofpageids._getsize /*int*/ ()-1))));
 //BA.debugLineNum = 568;BA.debugLine="End Sub";
return null;
}
public void  _handlecloserequest(b4a.example.b4xpagesmanager._b4xpageinfo _pi) throws Exception{
ResumableSub_HandleCloseRequest rsub = new ResumableSub_HandleCloseRequest(this,_pi);
rsub.resume(ba, null);
}
public static class ResumableSub_HandleCloseRequest extends BA.ResumableSub {
public ResumableSub_HandleCloseRequest(b4a.example.b4xpagesmanager parent,b4a.example.b4xpagesmanager._b4xpageinfo _pi) {
this.parent = parent;
this._pi = _pi;
}
b4a.example.b4xpagesmanager parent;
b4a.example.b4xpagesmanager._b4xpageinfo _pi;
anywheresoftware.b4a.keywords.Common.ResumableSubWrapper _rs = null;
boolean _shouldclose = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 512;BA.debugLine="LogEvent(pi, \"B4XPage_CloseRequest\")";
parent._logevent(_pi,"B4XPage_CloseRequest");
 //BA.debugLineNum = 513;BA.debugLine="Dim rs As ResumableSub = CallSub(pi.B4XPage, \"B4X";
_rs = new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper();
_rs = (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), (anywheresoftware.b4a.BA.ResumableSub)(parent.__c.CallSubNew(ba,_pi.B4XPage /*Object*/ ,"B4XPage_CloseRequest")));
 //BA.debugLineNum = 514;BA.debugLine="Wait For (rs) Complete (ShouldClose As Boolean)";
parent.__c.WaitFor("complete", ba, this, _rs);
this.state = 5;
return;
case 5:
//C
this.state = 1;
_shouldclose = (Boolean) result[0];
;
 //BA.debugLineNum = 515;BA.debugLine="If ShouldClose Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_shouldclose) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 516;BA.debugLine="ClosePage(pi.B4XPage)";
parent._closepage(_pi.B4XPage /*Object*/ );
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 518;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _complete(boolean _shouldclose) throws Exception{
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _module = null;
 //BA.debugLineNum = 59;BA.debugLine="Public Sub Initialize (Activity As Activity)";
 //BA.debugLineNum = 63;BA.debugLine="IdToB4XPage.Initialize";
_idtob4xpage._initialize /*String*/ (ba);
 //BA.debugLineNum = 64;BA.debugLine="RootB4XToPage.Initialize";
_rootb4xtopage._initialize /*String*/ (ba);
 //BA.debugLineNum = 65;BA.debugLine="mStackOfPageIds.Initialize";
_mstackofpageids._initialize /*String*/ (ba);
 //BA.debugLineNum = 69;BA.debugLine="Context.InitializeContext";
_context.InitializeContext(ba);
 //BA.debugLineNum = 70;BA.debugLine="mMainForm = Activity";
_mmainform = _activity;
 //BA.debugLineNum = 71;BA.debugLine="CheckMainActivityOrientations";
_checkmainactivityorientations();
 //BA.debugLineNum = 72;BA.debugLine="Dim jo As JavaObject = Me";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(this));
 //BA.debugLineNum = 73;BA.debugLine="Dim module As JavaObject";
_module = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 74;BA.debugLine="module.InitializeStatic(jo.RunMethodJO(\"getActivi";
_module.InitializeStatic(BA.ObjectToString(_jo.RunMethodJO("getActivityBA",(Object[])(__c.Null)).GetField("className"))).SetField("dontPause",(Object)(__c.True));
 //BA.debugLineNum = 78;BA.debugLine="B4XPages.InternalSetPagesManager(Me)";
_b4xpages._internalsetpagesmanager /*String*/ (ba,this);
 //BA.debugLineNum = 79;BA.debugLine="MainPage.Initialize";
_mainpage._initialize /*String*/ (ba);
 //BA.debugLineNum = 80;BA.debugLine="IdToB4XPage.Put(\"~~~~~temp~~~~\", CreateB4XPageInf";
_idtob4xpage._put /*String*/ ((Object)("~~~~~temp~~~~"),(Object)(_createb4xpageinfo((Object)(_mainpage),"",__c.False,(Object)(""))));
 //BA.debugLineNum = 81;BA.debugLine="BackgroundStateChanged(True)";
_backgroundstatechanged(__c.True);
 //BA.debugLineNum = 82;BA.debugLine="IdToB4XPage.Remove(\"~~~~~temp~~~~\")";
_idtob4xpage._remove /*String*/ ((Object)("~~~~~temp~~~~"));
 //BA.debugLineNum = 83;BA.debugLine="AddPageAndCreate(\"MainPage\", MainPage)";
_addpageandcreate("MainPage",(Object)(_mainpage));
 //BA.debugLineNum = 84;BA.debugLine="Log(\"Call B4XPages.GetManager.LogEvents = True to";
__c.LogImpl("97798809","Call B4XPages.GetManager.LogEvents = True to enable logging B4XPages events.",0);
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _logevent(b4a.example.b4xpagesmanager._b4xpageinfo _pi,String _ev) throws Exception{
String _msg = "";
 //BA.debugLineNum = 613;BA.debugLine="Private Sub LogEvent (pi As B4XPageInfo, ev As Str";
 //BA.debugLineNum = 614;BA.debugLine="If LogEvents Then";
if (_logevents) { 
 //BA.debugLineNum = 615;BA.debugLine="Dim msg As String = $\"*** ${pi.Id}: ${ev} ${Stac";
_msg = ("*** "+__c.SmartStringFormatter("",(Object)(_pi.Id /*String*/ ))+": "+__c.SmartStringFormatter("",(Object)(_ev))+" "+__c.SmartStringFormatter("",(Object)(_stackstring))+"");
 //BA.debugLineNum = 616;BA.debugLine="Log(msg)";
__c.LogImpl("910027011",_msg,0);
 };
 //BA.debugLineNum = 618;BA.debugLine="End Sub";
return "";
}
public String  _mainform_resize(double _width,double _height) throws Exception{
int _w = 0;
int _h = 0;
 //BA.debugLineNum = 558;BA.debugLine="Public Sub MainForm_Resize(Width As Double, Height";
 //BA.debugLineNum = 559;BA.debugLine="Dim w As Int = Width";
_w = (int) (_width);
 //BA.debugLineNum = 560;BA.debugLine="Dim h As Int = Height";
_h = (int) (_height);
 //BA.debugLineNum = 561;BA.debugLine="RaiseEvent(GetPageInfoFromRoot(Sender), \"B4XPage_";
_raiseevent(_getpageinfofromroot((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba)))),"B4XPage_Resize",new Object[]{(Object)(_w),(Object)(_h)});
 //BA.debugLineNum = 562;BA.debugLine="End Sub";
return "";
}
public String  _raiseevent(b4a.example.b4xpagesmanager._b4xpageinfo _targetpage,String _subname,Object[] _params) throws Exception{
int _length = 0;
 //BA.debugLineNum = 521;BA.debugLine="Public Sub RaiseEvent (TargetPage As B4XPageInfo,";
 //BA.debugLineNum = 522;BA.debugLine="If TargetPage = Null Then Return";
if (_targetpage== null) { 
if (true) return "";};
 //BA.debugLineNum = 523;BA.debugLine="Dim length As Int";
_length = 0;
 //BA.debugLineNum = 524;BA.debugLine="If Params = Null Then length = 0 Else length = Pa";
if (_params== null) { 
_length = (int) (0);}
else {
_length = _params.length;};
 //BA.debugLineNum = 525;BA.debugLine="LogEvent(TargetPage, SubName)";
_logevent(_targetpage,_subname);
 //BA.debugLineNum = 526;BA.debugLine="If xui.SubExists(TargetPage.B4XPage, SubName, len";
if (_xui.SubExists(ba,_targetpage.B4XPage /*Object*/ ,_subname,_length)==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 527;BA.debugLine="Select length";
switch (_length) {
case 0: {
 //BA.debugLineNum = 529;BA.debugLine="CallSubDelayed(TargetPage.B4XPage, SubName)";
__c.CallSubDelayed(ba,_targetpage.B4XPage /*Object*/ ,_subname);
 break; }
case 1: {
 //BA.debugLineNum = 531;BA.debugLine="CallSubDelayed2(TargetPage.B4XPage, SubName, Pa";
__c.CallSubDelayed2(ba,_targetpage.B4XPage /*Object*/ ,_subname,_params[(int) (0)]);
 break; }
case 2: {
 //BA.debugLineNum = 533;BA.debugLine="CallSubDelayed3(TargetPage.B4XPage, SubName, Pa";
__c.CallSubDelayed3(ba,_targetpage.B4XPage /*Object*/ ,_subname,_params[(int) (0)],_params[(int) (1)]);
 break; }
default: {
 //BA.debugLineNum = 535;BA.debugLine="Log(\"Too many parameters\")";
__c.LogImpl("99502734","Too many parameters",0);
 break; }
}
;
 //BA.debugLineNum = 537;BA.debugLine="End Sub";
return "";
}
public Object  _raiseeventwithresult(b4a.example.b4xpagesmanager._b4xpageinfo _targetpage,String _subname,Object[] _params) throws Exception{
int _length = 0;
 //BA.debugLineNum = 539;BA.debugLine="Public Sub RaiseEventWithResult (TargetPage As B4X";
 //BA.debugLineNum = 540;BA.debugLine="If TargetPage = Null Then Return Null";
if (_targetpage== null) { 
if (true) return __c.Null;};
 //BA.debugLineNum = 541;BA.debugLine="Dim length As Int";
_length = 0;
 //BA.debugLineNum = 542;BA.debugLine="If Params = Null Then length = 0 Else length = Pa";
if (_params== null) { 
_length = (int) (0);}
else {
_length = _params.length;};
 //BA.debugLineNum = 543;BA.debugLine="LogEvent(TargetPage, SubName)";
_logevent(_targetpage,_subname);
 //BA.debugLineNum = 544;BA.debugLine="If xui.SubExists(TargetPage.B4XPage, SubName, len";
if (_xui.SubExists(ba,_targetpage.B4XPage /*Object*/ ,_subname,_length)==__c.False) { 
if (true) return __c.Null;};
 //BA.debugLineNum = 545;BA.debugLine="Select length";
switch (_length) {
case 0: {
 //BA.debugLineNum = 547;BA.debugLine="Return CallSub(TargetPage.B4XPage, SubName)";
if (true) return __c.CallSubNew(ba,_targetpage.B4XPage /*Object*/ ,_subname);
 break; }
case 1: {
 //BA.debugLineNum = 549;BA.debugLine="Return CallSub2(TargetPage.B4XPage, SubName, Pa";
if (true) return __c.CallSubNew2(ba,_targetpage.B4XPage /*Object*/ ,_subname,_params[(int) (0)]);
 break; }
case 2: {
 //BA.debugLineNum = 551;BA.debugLine="Return CallSub3(TargetPage.B4XPage, SubName, Pa";
if (true) return __c.CallSubNew3(ba,_targetpage.B4XPage /*Object*/ ,_subname,_params[(int) (0)],_params[(int) (1)]);
 break; }
default: {
 //BA.debugLineNum = 553;BA.debugLine="Log(\"Too many parameters\")";
__c.LogImpl("99568270","Too many parameters",0);
 break; }
}
;
 //BA.debugLineNum = 555;BA.debugLine="Return Null";
if (true) return __c.Null;
 //BA.debugLineNum = 556;BA.debugLine="End Sub";
return null;
}
public String  _settitle(Object _b4xpage,Object _title) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 336;BA.debugLine="Public Sub SetTitle (B4XPage As Object, Title As O";
 //BA.debugLineNum = 337;BA.debugLine="Dim pi As B4XPageInfo = FindPIFromB4XPage(B4XPage";
_pi = _findpifromb4xpage(_b4xpage);
 //BA.debugLineNum = 338;BA.debugLine="pi.Title = Title";
_pi.Title /*Object*/  = _title;
 //BA.debugLineNum = 339;BA.debugLine="pi.Parent.NativeType.Title = Title";
_pi.Parent /*b4a.example.b4xpagesmanager._b4xpageparent*/ .NativeType /*anywheresoftware.b4a.objects.ActivityWrapper*/ .setTitle(BA.ObjectToCharSequence(_title));
 //BA.debugLineNum = 340;BA.debugLine="End Sub";
return "";
}
public String  _showpage(String _id) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
b4a.example.b4xpagesmanager._b4xpageinfo _top = null;
 //BA.debugLineNum = 133;BA.debugLine="Public Sub ShowPage (Id As String)";
 //BA.debugLineNum = 134;BA.debugLine="Dim pi As B4XPageInfo = GetPageFromId(Id)";
_pi = _getpagefromid(_id);
 //BA.debugLineNum = 135;BA.debugLine="If pi = GetTopPage Then Return";
if ((_pi).equals(_gettoppage())) { 
if (true) return "";};
 //BA.debugLineNum = 136;BA.debugLine="CreatePageIfNeeded(pi)";
_createpageifneeded(_pi);
 //BA.debugLineNum = 137;BA.debugLine="TopPageDisappear";
_toppagedisappear();
 //BA.debugLineNum = 139;BA.debugLine="Dim Top As B4XPageInfo = GetTopPage";
_top = _gettoppage();
 //BA.debugLineNum = 140;BA.debugLine="If Top <> Null Then";
if (_top!= null) { 
 //BA.debugLineNum = 141;BA.debugLine="Top.Root.RemoveViewFromParent";
_top.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .RemoveViewFromParent();
 };
 //BA.debugLineNum = 151;BA.debugLine="mStackOfPageIds.Remove(pi.Id)";
_mstackofpageids._remove /*String*/ ((Object)(_pi.Id /*String*/ ));
 //BA.debugLineNum = 152;BA.debugLine="ShowPageImpl(pi)";
_showpageimpl(_pi);
 //BA.debugLineNum = 153;BA.debugLine="mStackOfPageIds.Add(pi.Id)";
_mstackofpageids._add /*String*/ ((Object)(_pi.Id /*String*/ ));
 //BA.debugLineNum = 154;BA.debugLine="TopPageAppear";
_toppageappear();
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return "";
}
public String  _showpageandremovepreviouspages(String _id) throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
b4a.example.b4xpagesmanager._b4xpageinfo _pagetoremove = null;
 //BA.debugLineNum = 157;BA.debugLine="Public Sub ShowPageAndRemovePreviousPages (Id As S";
 //BA.debugLineNum = 158;BA.debugLine="If GetTopPage = Null Then";
if (_gettoppage()== null) { 
 //BA.debugLineNum = 159;BA.debugLine="ShowPage(Id)";
_showpage(_id);
 //BA.debugLineNum = 160;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 162;BA.debugLine="Dim pi As B4XPageInfo = GetPageFromId(Id)";
_pi = _getpagefromid(_id);
 //BA.debugLineNum = 163;BA.debugLine="CreatePageIfNeeded(pi)";
_createpageifneeded(_pi);
 //BA.debugLineNum = 164;BA.debugLine="TopPageDisappear";
_toppagedisappear();
 //BA.debugLineNum = 168;BA.debugLine="For Each Id As String In mStackOfPageIds.AsList";
{
final anywheresoftware.b4a.BA.IterableList group8 = _mstackofpageids._aslist /*anywheresoftware.b4a.objects.collections.List*/ ();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_id = BA.ObjectToString(group8.Get(index8));
 //BA.debugLineNum = 169;BA.debugLine="Dim PageToRemove As B4XPageInfo = GetPageFromId(";
_pagetoremove = _getpagefromid(_id);
 //BA.debugLineNum = 171;BA.debugLine="PageToRemove.Root.RemoveViewFromParent";
_pagetoremove.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .RemoveViewFromParent();
 }
};
 //BA.debugLineNum = 178;BA.debugLine="mStackOfPageIds.Clear";
_mstackofpageids._clear /*String*/ ();
 //BA.debugLineNum = 179;BA.debugLine="mStackOfPageIds.Add(pi.Id)";
_mstackofpageids._add /*String*/ ((Object)(_pi.Id /*String*/ ));
 //BA.debugLineNum = 180;BA.debugLine="If xui.IsB4A Or xui.IsB4J Then";
if (_xui.getIsB4A() || _xui.getIsB4J()) { 
 //BA.debugLineNum = 181;BA.debugLine="ShowPageImpl(pi)";
_showpageimpl(_pi);
 };
 //BA.debugLineNum = 183;BA.debugLine="TopPageAppear";
_toppageappear();
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public String  _showpageimpl(b4a.example.b4xpagesmanager._b4xpageinfo _pi) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
 //BA.debugLineNum = 307;BA.debugLine="Private Sub ShowPageImpl (pi As B4XPageInfo)";
 //BA.debugLineNum = 313;BA.debugLine="If pi.Root.Parent.IsInitialized Then pi.Root.Remo";
if (_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getParent().IsInitialized()) { 
_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .RemoveViewFromParent();};
 //BA.debugLineNum = 314;BA.debugLine="Dim pnl As Panel = pi.Root";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(_pi.Root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()));
 //BA.debugLineNum = 315;BA.debugLine="If TransitionAnimationDuration > 0 Then";
if (_transitionanimationduration>0) { 
 //BA.debugLineNum = 316;BA.debugLine="mMainForm.AddView(pnl, 0, 0, 20dip, 20dip)";
_mmainform.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),__c.DipToCurrent((int) (20)),__c.DipToCurrent((int) (20)));
 //BA.debugLineNum = 317;BA.debugLine="pnl.SetLayoutAnimated(TransitionAnimationDuratio";
_pnl.SetLayoutAnimated(_transitionanimationduration,(int) (0),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (100),ba));
 }else {
 //BA.debugLineNum = 319;BA.debugLine="mMainForm.AddView(pnl, 0, 0, 100%x, 100%y)";
_mmainform.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),__c.PerXToCurrent((float) (100),ba),__c.PerYToCurrent((float) (100),ba));
 };
 //BA.debugLineNum = 324;BA.debugLine="End Sub";
return "";
}
public String  _toppageappear() throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 262;BA.debugLine="Private Sub TopPageAppear";
 //BA.debugLineNum = 263;BA.debugLine="Dim pi As B4XPageInfo = GetTopPage";
_pi = _gettoppage();
 //BA.debugLineNum = 264;BA.debugLine="If pi = Null Then Return";
if (_pi== null) { 
if (true) return "";};
 //BA.debugLineNum = 265;BA.debugLine="pi.Parent.NativeType.Title = pi.Title";
_pi.Parent /*b4a.example.b4xpagesmanager._b4xpageparent*/ .NativeType /*anywheresoftware.b4a.objects.ActivityWrapper*/ .setTitle(BA.ObjectToCharSequence(_pi.Title /*Object*/ ));
 //BA.debugLineNum = 266;BA.debugLine="If Not(xui.IsB4i) Then";
if (__c.Not(_xui.getIsB4i())) { 
 //BA.debugLineNum = 267;BA.debugLine="If IsForeground Then";
if (_isforeground) { 
 //BA.debugLineNum = 268;BA.debugLine="RaiseEvent(pi, \"B4XPage_Appear\", Null)";
_raiseevent(_pi,"B4XPage_Appear",(Object[])(__c.Null));
 };
 };
 //BA.debugLineNum = 272;BA.debugLine="If ShowUpIndicator And ActionBar.IsInitialized Th";
if (_showupindicator && _actionbar.IsInitialized()) { 
 //BA.debugLineNum = 273;BA.debugLine="ActionBar.RunMethod(\"setDisplayHomeAsUpEnabled\",";
_actionbar.RunMethod("setDisplayHomeAsUpEnabled",new Object[]{(Object)(_mstackofpageids._getsize /*int*/ ()>1)});
 };
 //BA.debugLineNum = 275;BA.debugLine="UpdateMenuItems";
_updatemenuitems();
 //BA.debugLineNum = 277;BA.debugLine="UpdateStackString";
_updatestackstring();
 //BA.debugLineNum = 278;BA.debugLine="End Sub";
return "";
}
public String  _toppagedisappear() throws Exception{
b4a.example.b4xpagesmanager._b4xpageinfo _pi = null;
 //BA.debugLineNum = 251;BA.debugLine="Private Sub TopPageDisappear";
 //BA.debugLineNum = 252;BA.debugLine="If xui.IsB4J Then Return";
if (_xui.getIsB4J()) { 
if (true) return "";};
 //BA.debugLineNum = 253;BA.debugLine="Dim pi As B4XPageInfo = GetTopPage";
_pi = _gettoppage();
 //BA.debugLineNum = 254;BA.debugLine="If pi = Null Then Return";
if (_pi== null) { 
if (true) return "";};
 //BA.debugLineNum = 255;BA.debugLine="If Not(xui.IsB4i) Then";
if (__c.Not(_xui.getIsB4i())) { 
 //BA.debugLineNum = 256;BA.debugLine="If IsForeground Then";
if (_isforeground) { 
 //BA.debugLineNum = 257;BA.debugLine="RaiseEventWithResult(pi, \"B4XPage_Disappear\", N";
_raiseeventwithresult(_pi,"B4XPage_Disappear",(Object[])(__c.Null));
 };
 };
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
return "";
}
public String  _updatemenuitems() throws Exception{
 //BA.debugLineNum = 463;BA.debugLine="Private Sub UpdateMenuItems";
 //BA.debugLineNum = 464;BA.debugLine="Context.RunMethod(\"invalidateOptionsMenu\", Null)";
_context.RunMethod("invalidateOptionsMenu",(Object[])(__c.Null));
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public String  _updatestackstring() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
String _id = "";
 //BA.debugLineNum = 620;BA.debugLine="Public Sub UpdateStackString";
 //BA.debugLineNum = 621;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 622;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 623;BA.debugLine="sb.Append(\"[\")";
_sb.Append("[");
 //BA.debugLineNum = 624;BA.debugLine="If mStackOfPageIds.Size > 0 Then";
if (_mstackofpageids._getsize /*int*/ ()>0) { 
 //BA.debugLineNum = 625;BA.debugLine="For Each id As String In mStackOfPageIds.AsList";
{
final anywheresoftware.b4a.BA.IterableList group5 = _mstackofpageids._aslist /*anywheresoftware.b4a.objects.collections.List*/ ();
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_id = BA.ObjectToString(group5.Get(index5));
 //BA.debugLineNum = 626;BA.debugLine="sb.Append(id).Append(\", \")";
_sb.Append(_id).Append(", ");
 }
};
 //BA.debugLineNum = 628;BA.debugLine="sb.Remove(sb.Length - 2, sb.Length)";
_sb.Remove((int) (_sb.getLength()-2),_sb.getLength());
 };
 //BA.debugLineNum = 630;BA.debugLine="sb.Append(\"]\")";
_sb.Append("]");
 //BA.debugLineNum = 631;BA.debugLine="StackString = sb.ToString";
_stackstring = _sb.ToString();
 //BA.debugLineNum = 632;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
public static class PagesMenuListener implements android.view.MenuItem.OnMenuItemClickListener {
	private B4AClass target;
	private String tag;
	public PagesMenuListener(B4AClass target, String tag) {
		this.target = target;
		this.tag = tag;
	}
 	public boolean onMenuItemClick(android.view.MenuItem item) {
		target.getBA().raiseEventFromUI(null, "b4xpage_menuclick", tag);
		return true;
	}
}
}
