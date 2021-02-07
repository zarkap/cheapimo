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

	Private toolbarhelper As ACActionMenu
	Private ACToolBarLight1 As ACToolBarLight
	Private TabStrip1 As TabStrip
	Private HorizontalScrollView1 As HorizontalScrollView
	Private ScrollView1 As ScrollView
	Private ScrollView2 As ScrollView
	Private ScrollView3 As ScrollView
	
	Dim arz As Int
	Dim a1 As Float
	Dim tool As Int
	Dim t1 As Float
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("MainPage")
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
			HorizontalScrollView1.Panel.AddView(hslist,arz,0,45%X,200)
			HorizontalScrollView1.Tag=j
			a1=45%x
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
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub tabfview ()
	
	

	
End Sub