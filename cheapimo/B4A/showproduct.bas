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

	Private ScrollView1 As ScrollView
	
	Dim jodasazi As Int
	Dim tool(2) As Int
	Dim t1 As Float
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("showsubject")

	For i=0 To 20
		Dim prshow As Panel
		prshow.Initialize("prsh")
		prshow.Tag=i
		prshow.LoadLayout("product")
		t1=210
		prshow.Height=t1
		jodasazi=i Mod 2
		If jodasazi=0 Then
			ScrollView1.Panel.AddView(prshow,0,tool(0),49.5%x,200)
			tool(0)=tool(0)+t1+1%y
			Else
				ScrollView1.Panel.AddView(prshow,50.5%x,tool(1),100%x,200)
			tool(1)=tool(1)+t1+1%y
		End If
	Next
	ScrollView1.Panel.Height=tool(0)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
