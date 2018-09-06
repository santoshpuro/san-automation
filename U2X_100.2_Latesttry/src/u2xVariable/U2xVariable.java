package u2xVariable;

import org.apache.log4j.Logger;

import u2xRunnablescripts.Runnable;

public class U2xVariable {
	
	public static int i = 1;


	//LaunchUrl class:
	//public static String browserpath = "C:/AutomationWorkspace/chromedriver.exe" ;
	public static String browserpath = "C://java22//selenium//chromedriver.exe";	
	//public static String browserpath = "C://java22//selenium//chromedriver//chromedriver.exe";	
	public static String baseUrl = "https://myubenefits.qa.univers.aon.net/WeezerAccess/";	
	//public static String baseUrl = "https://myubenefits.qa.univers.aon.net/WeezerAccess_UAT";
	//public static String baseUrl = "https://myubenefits.qc.univers.aon.net/WeezerAccess_STG/";

	public static Logger logger =Logger.getLogger(Runnable.class);
	public static String current ;
	public static String excelData;
	
//LoginPage class 
public static String guID;
public static String userName;
public static String organiztionId;

public static String clientType;
public static String iD_userName = "UserName";		
public static String iD_orgId = "EmployeeOrgID";
public static String iD_logbtn = "btnLogin";


//WeezerQaPage class:
public static String systemDate;
public static String xId_systemDate = "txtAdminSystemDate";
public static String xId_ddlApplication = "ddlApplication";
public static String applicationname;
public static String xId_btnAdminLogin = "btnAdminLogin";

//SelfService Class:
public static String id_SSUserName = "UserName";	
public static String id_SSPassword = "Password";
public static String id_SSLoginButton = "btnSignIn";

public static String xPath_Register="//*[@id='login-box']/h2";
public static String xpath_Signin = "//*[@id='register-box']/div[1]/a";
public static String xPath_Element = "//*[@id='login-box']/form/div[1]/div";

public static String SS_UserName;	
public static String SS_Password;


//Class: EmployeeLookup: for Counsler:
public static String uId;
public static String reasonCode = "Override security";
public static String xId_uId = "txtUID";
public static String xid_reasonCode = "drpAccessReason";
public static String xId_Lookupbtn ="btnSignIn";
public static String id_EnrolleeNameHyperlink = "//td[2]/a";

//HomePage Class:
public static String id_HomeLink = "HomeHome";
public static String xPath_AdminPanelAELink = "//form/div[1]/div[2]/ul[1]/li/ul/li[1]/a";
public static String xPath_PromoAeLink = "/html/body/div[1]/div[2]/div[3]/div[2]/div/div/div/ul/li[2]/div[2]/a";
public static String xPath_DotLink = "//div/div/div[2]/div[1]/div[1]/a";
public static String id_LifeEventLinkOnHomePage =  "LifeEventsLifeEvents";
public static String xPath_AdminCoverageMaintenanceLinkOnHomePage =  "//form/div[1]/div[2]/ul[3]/li/ul/li[5]/a";
public static String id_BacktoLookUpLink = "lnkBack";


//LifeEvents class:

public static String event;
public static String url;
public static String xPath_LifeEventTextonLifeEventPage = "//form/div/div/div[1]/h1";
public static String xPath_LifeEventGoLink  = "//form/div/div/div[2]/div[1]/div[1]/p/a";
public static String id_EventDate  = "txtEventDate";
public static String xPath_EventDate  = "//*[@id='txtEventDate']";
public static String  xPath_LifeEventPopUpContinueButton = "//form/div[2]/div[1]/div[5]/button";

//Class: HomePageFunctions

public static String lnkTxt_home = "Home";
public static String xPath_home = "//*[@id='HomeHome']/a";
public static String xId_imgHomeIcon ="imgLogo";
//public static String xPath_imgHomeIcon ="//*[@id='imgLogo']";

//******************  Profile Tab  ***************************

public static String lnkTxt_profile = "Profile";
public static String xPath_profile = "//*[@id='ProfileHome']/a";


//******************  Personal Tab  ***************************
public static String lntTxt_personal ="Personal";
public static String xPath_personal ="//ul[2]/li/ul/li/a";
public static String xPath_btn_Submit = ".//*[@id='btnsubmit']";
public static String xName_mid_Name = "MiddleName";
public static String id_btn_submit = "btnsubmit";
public static String xPath_btn_Close = "//*[@id='closeBtn']";

//Variable passing
	public static String mid_name = "M";
	public static String mid_name_ActivityProfile = "L";



//******************  Family Tab  ***************************

public static String lnkTxt_family = "Family";
public static String id_family = "lnkFamily";
public static String xPath_family = "//ul[2]/li/ul/li[2]/a";
public static String id_btn_family = "btnFamily";
public static String xPath_btn_DependentDetails = ".//*[@id=' btnvedependentdetails']";
public static String xPath_btn_Close_DependentDetails_popup ="/html/body/div[20]/div/div/a[3]/span";
public static String xPath_btn_Close_DependentDetails_popup_activityprofile ="//div[8]/div[1]/div/a[3]/span";


//******************  Beneficiary Tab  ***************************

public static String lnkTxt_beneficiary = "Beneficiary";
public static String id_beneficiary = "lnkBeneficiary";
public static String xPath_beneficiary = "//ul[2]/li/ul/li[3]/a";//*[@id="btnBeneficiary"]
public static String id_btn_beneficiary = "btnBeneficiary";
public static String xPath_btn_BeneficiryDetails ="//*[@id=' btnveBeneficiryDetails']";
//public static String xPath_btn_Close_BeneficiryDetails_popup = "//div[11]/div[1]/div/a[3]/span";
public static String xPath_btn_Close_BeneficiryDetails_popup = "div[23]/div[1]/div/a[3]/span";


//******************  Beneficiary Tab  ***************************

public static String lnkTxt_Employment = "Employment";
public static String xPath_Employment = "//ul[2]/li/ul/li[4]/a";
public static String id_btn_Employment = "btnEmployment";
public static String xPath_Emp_element = "//*[@id='employment-table']/h3";


//******************  Contact Tab  ***************************

public static String lnkTxt_Contact = "Contact";
public static String xPath_Contact = "//ul[2]/li/ul/li[5]/a";
public static String id_btn_Contact = "btnContact";
public static String xPath_Contact_element = "//*[@id='divMyContact']/div[1]/h3";


//******************  Benefits Tab  ***************************

public static String lnkTxt_Benefits = "Benefits";
public static String xPath_Benefits = "//ul[2]/li/ul/li[6]/a";
public static String id_btn_Benefits = "btnBenefits";
public static String xPath_Benefits_element =  "//*[@id='benefitTitle']";


//******************  Miscellaneous Tab  ***************************

public static String lnkTxt_Miscellaneous = "Miscellaneous";
public static String xPath_Miscellaneous = "//ul[2]/li/ul/li[7]/a";
public static String id_btn_Miscellaneous = "btnMiscellaneous";
public static String xPath_Miscellaneous_element =  "//*[@id='employment-table']/h3";


//******************  Health Tab  ***************************

public static String lnkTxt_Health = "Health";
public static String xPath_Health = "//ul[2]/li/ul/li[8]/a";
public static String id_btn_Health = "btnHealth";
public static String xPath_tab_Health = "//*[@id='HomeLearn']/a";
public static String xPath_Health_element =  "//*[@id='employment-table']/h3";
public static String xPath_No_Health_Questions =  "//*[@id='divHealthNotification']/h4";
public static String id_btn_Save ="btnSave";
public static String id_btn_Close ="closeBtn";


//******************  LifeEvent Tab  ***************************


public static String lnkTxt_LifeEvent = "Life Event";
public static String xPath_LifeEvent_tab ="//*[@id='LifeEventsLifeEvents']/a";//*[@id="LifeEventsLifeEvents"]
public static String xPath_LifeEvent_element = "//*[@id='mc']/div[1]/h1";
//public static String  xPath_LifeEventPopUpContinueButton = "//form/div[2]/div[1]/div[5]/button";


//******************  Learn Tab  ***************************


public static String lnkTxt_Learn = "Learn";
public static String xPath_Learn_tab ="//*[@id='HomeLearn']/a";
//public static String xPath_Learn_element = "//*[@id='mc']/div[1]/h1";


//******************  CurrentBenefits   ***************************


public static String xPath_MedicalTab = "//*[@id='accordion']/div[1]/div[1]/h4/a";
public static String xPath_DentalTab = "//*[@id='accordion']/div[2]/div[1]/h4/a";
public static String xPath_VisionTab = "//*[@id='accordion']/div[3]/div[1]/h4/a";
public static String xPath_Benefit = "//*[@id='mod1']/p/a/span";


//                Activity Adminpanel  

//****************** Activity History ********************************

public static String lnkText_A_History ="Activity History";
public static String xPath_A_History ="//ul[3]/li/ul/li/a";
public static String id_btn_back ="btnBack";

//**************** "Payroll Maintenance" ***************************

public static String lnkText_A_PayrollMaintenace ="Payroll Maintenance";
public static String xPath_A_PayrollMaintenace ="//ul[3]/li/ul/li[2]/a";

public static int input_EmployeePayroll =1;
public static int input_PayrollGroup =1;
public static int input_PayrollFrequency =1;

public static String id_element_EmployeePayroll ="drpEmployeePayroll";
public static String id_element_PayrollGroup ="drpPayrollGroup";
public static String id_element_PayrollFrequency ="drpPayrollFrequency";

public static String id_btn_Search ="btnSearch";



//**************** "Plan Override" ***************************

public static String lnkText_A_PlanOverride ="Plan Override";
public static String xPath_A_PlanOverride ="//ul[3]/li/ul/li[3]/a";

//**************** "Password Reset"  *********************

public static String lnkText_A_PasswordReset ="Password Reset";
public static String xPath_A_PasswordReset ="//ul[3]/li/ul/li[4]/a";
public static String xPath_btn_SubmitReset ="//*[@id='btnSubmitReset']";
public static String xPath_btn_Close_PasswordReset_popup ="//html/body/div[7]/div[1]/div/a/span";


//**************** "Admin coverage maintenance"  *********************

public static String lnkText_A_Admincoveragemaintenance ="Admin coverage maintenance";
public static String xPath_A_Admincoveragemaintenance ="//ul[3]/li/ul/li[5]/a";
public static String xPath_btn_back ="//*[@id='btnback']/span";


//**************** "Admin coverage maintenance"  *********************

public static String lnkText_A_VBAdmincoveragemaintenance ="VB Admin Coverage Maintenance";
public static String xPath_A_VBAdmincoveragemaintenance ="//ul[3]/li/ul/li[6]/a";


//Class: AnnualEnrollmentWelcomePage:
public static String xId_ContinueButtonOnAnnualEnrollmentWelcomePage = "//*[@id='successLifeevent']/p/text()";    //"/html/body/div[1]/div[2]/div/div/div[2]/div[2]/form/div[2]/div[1]/div[5]/p[1]";

//public static String xPath_ContinueButtonOnAnnualEnrollmentWelcomePage = "//div[1]/a/span";
public static String id_ContinueButtonOnAnnualEnrollmentWelcomePage = "showHomeDialog";
public static String xPath_ContinueButtonOfIncompletedEnrollment = "//form/div[2]/div[1]/div[1]/button";
public static String xPath_ContinueButtonOfCompletedEnrollment = "//form/div[2]/div[1]/div[2]/button";
public static String xPath_incompleteEnrollment = "//form/div[2]/div[1]/div[1]/a/i";
public static String xPath_newHireisNotCompleted = "//form/div[2]/div[1]/div[3]/button";

//Class: PersonalPage:
public static String xPath_ContinueButtonOnPersonalPage = "//div[2]/button[2]";
public static String xPath_PersonalTitle = "//form/div/div[1]/h3";

//Class: FamilyPage:
//public static String xPath_ContinueButtonOnFamilyPage = "//div[2]/button[2]";
public static String xPath_dependentsRecordCount = "//div/div/div[3]/span[2]";
public static String id_ContinueButtonOnFamilyPage = "btnStep1Continue";
public static String xPath_DependentCheck = "//table/tbody/tr/td[3]";
public static String id_AddPersonButton = "anchAddDependent";
public static String Id_RelationshipBeginDate = "txtdependentEffectiveDate";
public static String Id_RelationshipType = "lblRelationship";
public static String relationshipBeginDate = "01/09/2010"; 
public static String id_DependentFirstName = "Ref_Dependent_FirstName";
public static String dependentFirstName = "Steve";
public static String id_DependentLastName = "Ref_Dependent_LastName";
public static String dependentLastName = "White";
public static String id_DependentDOB = "Ref_Dependent_DOB";
public static String dependentDOB = "01/25/1980";
public static String id_Gender= "Ref_Dependent_GenderID";
public static String id_Relationship = "drpRelationship";
public static String relationship = "Spouse";
public static String xPath_SaveButton = "//form/div[7]/div[2]/input[2]";
public static String xPath_DependentAttestationQuestionnaireDropdown = "//form/div/div[1]/div/table/tbody/tr/td[2]/select";
public static String DependentAttestationQuestionnaireDropdownValue = "Yes";
public static String iD_DependentAttestationQuestionnaireContinueButton = "btnSaveVBQuestions";
public static String iD_PopupOkButton = "closeBtn";

//class BeneficiaryPage:
public static String xPath_AddpersonButton = "//table/tbody/tr/td[1]/input"; 
public static String primarayRadioButton = "//table/tbody/tr/td[4]/label[1]/input";

//Class: ContactPage
public static String id_OtherEmailAddressText= "txtOtherEmail";
public static String id_OtherEmailAddressRb= "rdbOtherEmail";
public static String id_OtherPhoneNumberText= "txtOtherPhone";
public static String id_OtherPhoneNumberRb= "rdbOtherPhonePreferred";
public static String id_disclaimerRb= "IsAgreedToReceiveEnrollmentCalls";
public static String id_ContinueButtonOnContactpage= "btnStep1Continue";
public static String emailaddress = "b.a@gmail.com";
public static String phoneNumber = "9988776655";

//Class: Health screen
public static String id_health ="liHealth";
public static String xPath_healthQuestionDropdown = "//div[1]/div[2]/select";
public static String healthQuestionResponse = "No";
public static String id_ContinueButtonOnHealthscreen = "btnStep1Continue";

//Class:Plans
//First Plan page:
public static String xPath_ContinueButtonOnAllPlansAndSurveySCreen  = "//div[2]/div[3]/button[3]";
public static String id_ContinueButtonOnAllPlans = "btnNext";
public static String xPath_MedicalTypeFirstPlan = "//table/tbody/tr[1]/td/div/div/div[2]/a";
public static String xPath_CIEnrolleeFirstCoverage = "//table/tbody/tr[1]/td[1]/a/input";
public static String id_HcfsaTextBox = "txtCoverageAmount";
public static String xPath_SuppLifeDropdownbox = "//div[2]/div[1]/div[1]/span/span/span[1]";
public static String xPath_BeneficiaryLink = "//div[1]/div[1]/h4/a";
public static String xPath_BeneficiaryCheckbox  = "//table/tbody/tr[1]/td[1]/input";
public static String xPath_MedicalPopUp  = "/html/body/div[6]/div/a";
public static String xPath_KoPopupCancelLink  = "//form/div/div[2]/div/div[1]/div/button";
public static String id_KoPopupContinueButton  = "btnSaveVBQuestions";
public static String xPath_KoPopupAgreeButton  = "//form/div/div/div/div[4]/button[2]";
public static String id_KoPopupCloseButton  = "closeBtn";
public static String xPath_CITobaccoDropdown  = "//table/tbody/tr[1]/td[2]/select";
public static String CITobaccoDropdownResponse= "No";
public static String xPath_CIKoPopupCancelButton  = "//form/div/div[3]/div/div[1]/div/button";
public static String xPath_BeneficiaryRadioButton  = "//table/tbody/tr[1]/td[3]/label[1]/input";
public static String xPath_BeneficiaryAllocationClick  = "//div[1]/div/div[3]/table/tbody/tr/td[4]";
public static String xPath_BeneficiaryAllocationTextbox  = "//div[1]/div/div[3]/table/tbody/tr/td[4]/input";
public static String Allocation  = "100";
public static String id_StdReminderPopupButton  = "closeBtn";
public static String xPath_PopupAfterClickingContinueButton  = "//form/div/div[7]/div/p[3]/button";
public static String medicalPopupWaveOutText = "waveout";
public static String xPath_MedicalPopupWaveOut = "//table/tbody/tr/td[1]/input";
public static String xPath_MedicalPopupWaveOutContinueButton = "//body/div[7]/div/div/form/div/div[2]/button[2]";
public static String tobaccoAnswersInPlanPages = "No";
public static String xPath_suppLifeDropdownValue = "//li[@tabindex='-1'][@role='option'][@unselectable='on'][@data-offset-index='0']";
public static String xPath_responseText = "//input[@maxlength='250'][@value='']";
public static String responseTextValue = "Test";
public static String xPath_responseType = "//input[@onkeypress='keypresshandler(event)'][@value='']";
public static String responseTypeValue = "Test";
public static String xPath_BeniradioButton  = "//table/tbody/tr/td[4]/label[1]/input";
public static String xPath_BeniArrowOnPlan  = "//i[@class='indicator glyphicon glyphicon-chevron-right']";
public static String xPath_SuppAdDBox = "//*[@id='divCoverageDetail']/div[1]";

//Plans: Review and Submit page:
public static String xPath_ReviewSubmit = "//form/div/button[1]";
public static String xPath_reviewSubmitPlan = "//div[1]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/ul/li[1]";
public static String id_ResposeQuestionTextbox  = "txtResponse";
public static String resposeQuestionText  = "Test";
public static String xPath_CompleteEnrollmentButton   = "//form/div/button[1]";
public static String id_CompleteEnrollmentButton   = "btnSave";

//Survey page:
public static String xPath_surveyQuestion1  = "//form/div/div/div/div[2]/div/div[1]/div[2]/select";
public static String xPath_surveyQuestion2  = "//form/div/div/div/div[2]/div/div[2]/div[2]/select";
public static String xPath_surveyQuestion3  = "//form/div/div/div/div[2]/div/div[3]/div[2]/select";
public static String xPath_surveyQuestion4  = "//form/div/div/div/div[2]/div/div[4]/div[2]/select";
public static String xPath_surveyQuestion5  = "//form/div/div/div/div[2]/div/div[5]/div[2]/select";
public static String xPath_surveyQuestion6  = "//form/div/div/div/div[2]/div/div[6]/div[2]/select";

// Class: AdminCoverageMaintenance
public static String  xPath_FirstPlanOnReviewandSubmit = "//table[1]/tbody/tr/td[1]/a/span[1]";
public static String xPath_PlannameAfterBackFromReviewscreen =  "//div[2]/div[1]/div/div/div[1]/div/ul/li";
public static String id_backtoReviewAndSubmit =  "btnBacktoReviewSubmit";
public static String id_backtoReviewAndSubmitpopup =   "btnContinueResubmission";


}
