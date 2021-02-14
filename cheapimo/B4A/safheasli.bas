B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=10.2
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Dim toolbarhelper As ACActionBar
	Private ACToolBarLight1 As ACToolBarLight
	Private TabStrip1 As TabStrip
	Private HorizontalScrollView1 As HorizontalScrollView
	Private ScrollView1 As ScrollView
	Private ScrollView2 As ScrollView
	Private ScrollView3 As ScrollView
	
	Dim draw As B4XDrawer
	Dim arz As Int
	Dim a1 As Float
	Dim tool As Int
	Dim t1 As Float
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("MainPage")
	draw.Initialize(Me,"draw",Activity,50%x)
	draw.CenterPanel.LoadLayout("MainPage")
	draw.LeftPanel.LoadLayout("drawer")
	
	TabStrip1.LoadLayout("tab1","men")
	TabStrip1.LoadLayout("tab2","women")
	TabStrip1.LoadLayout("tab3","set")
	For i=0 To 4
		Dim listmenu As Panel
		listmenu.Initialize("lmpanel")
		listmenu.Tag=i
		listmenu.LoadLayout("list")
		ScrollView1.Panel.AddView(listmenu,0,tool,100%x,310)
		ScrollView1.Tag=i
		For j=0 To 4
			Dim hslist As Panel
			hslist.Initialize("hspanel")
			hslist.Tag=j
			hslist.LoadLayout("product")
			HorizontalScrollView1.Panel.AddView(hslist,arz,0,38%X,200)
			HorizontalScrollView1.Tag=j
			a1=38%x
			hslist.Width=a1+2%x
			arz=arz+a1+1%x
		Next
		HorizontalScrollView1.Panel.Width=arz
		arz=0
		t1=250
		listmenu.Height=t1 + 2%y
		tool=tool+t1+1%y
	Next
	ScrollView1.Panel.Height=tool
	tool=0
	
	For i=0 To 4
		Dim listmenu As Panel
		listmenu.Initialize("lmpanel")
		listmenu.Tag=i
		listmenu.LoadLayout("list")
		ScrollView2.Panel.AddView(listmenu,0,tool,100%x,310)
		ScrollView2.Tag=i
		For j=0 To 4
			Dim hslist As Panel
			hslist.Initialize("hspanel")
			hslist.Tag=j
			hslist.LoadLayout("product")
			HorizontalScrollView1.Panel.AddView(hslist,arz,0,38%X,200)
			HorizontalScrollView1.Tag=j
			a1=38%x
			hslist.Width=a1+2%x
			arz=arz+a1+1%x
		Next
		HorizontalScrollView1.Panel.Width=arz
		arz=0
		t1=250
		listmenu.Height=t1 + 2%y
		tool=tool+t1+1%y
	Next
	ScrollView2.Panel.Height=tool
	tool=0
	
	For i=0 To 4
		Dim listmenu As Panel
		listmenu.Initialize("lmpanel")
		listmenu.Tag=i
		listmenu.LoadLayout("list")
		ScrollView3.Panel.AddView(listmenu,0,tool,100%x,310)
		ScrollView3.Tag=i
		For j=0 To 4
			Dim hslist As Panel
			hslist.Initialize("hspanel")
			hslist.Tag=j
			hslist.LoadLayout("product")
			HorizontalScrollView1.Panel.AddView(hslist,arz,0,38%X,200)
			HorizontalScrollView1.Tag=j
			a1=38%x
			hslist.Width=a1+2%x
			arz=arz+a1+1%x
		Next
		HorizontalScrollView1.Panel.Width=arz
		arz=0
		t1=250
		listmenu.Height=t1 + 2%y
		tool=tool+t1+1%y
	Next
	ScrollView3.Panel.Height=tool
	tool=0
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub ACToolBarLight1_NavigationItemClick
	draw.LeftOpen = Not(draw.LeftOpen)
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean 
	If KeyCode = KeyCodes.KEYCODE_BACK And draw.LeftOpen Then
		draw.LeftOpen = False
		Return True
	End If
	Return False
End Sub

Private Sub Label1_Click
	draw.LeftOpen = Not(draw.LeftOpen)
End Sub