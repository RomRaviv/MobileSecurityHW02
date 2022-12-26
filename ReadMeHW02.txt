There were issues with the Manifest file.
Some lines had to be deleted and some needed changing.
for example- platformBuildVersionCode = "30" was missing 'android' at the beggining.
android:debugable = "true" needed to be deleted.

On Menu_Activity:
C0081R.C0084id was replaced to R.id
<string name="url">https://pastebin.com/raw/T67TVJG9</string> needed to be deleted.

on Game_Activity:
C0081R was replaced to R
There wasn't any handling if the ID input was less than 9 digits. So a toast was added in case ID is less than 9 digits.
ID was supposed to be max of 9 digits so a an xml attribute was added- android:maxLength = "9"

the steps were %4 on the ID - final result: Survived in California.

