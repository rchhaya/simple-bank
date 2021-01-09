# simpleBank
A simple banking application that allows users to deposit, withdraw, and check balance.

The application first prompts the user for their name and current balance. Note that if the user enters a name with non-alphabetic characters or a balance with non-number 
characters, the application will re-prompt the user to enter valid information. The name is also capatalized if the user inputs a lowercase string. 

Then, the user is presented with 4 options and prompted to enter respective inputs: '1' to withdraw, '2' to deposit, '3' to check balance, and '4' to quit. If a non-numeric 
input is detected, the user is notified and instructed to re-enter a number. If the input is an integer but not 1, 2, 3, or 4, the user is told the number is out of range. 
Once a valid integer is detected, the respective action will take place. 

For withdrawing, the user is prompted for an amount to withdraw. Again, if a non-numeric input is detected, the user will be notified and sent back to the home screen
listing the 4 operations. If the user wants to withdraw more than their account holds, they will be told that this will result in overdrafting and is not allowed, followed by 
a return to the home screen. For depositing, the user is prompted for an amount to deposit. Again, if a non-numeric input is detected, the user will be notified and sent back to 
the home screen listing the 4 operations. For checking balance, the current balance is displayed for the user and no inputs are prompted.  For quitting, the bank notifies the user 
of the current balance and closes the program. 

Note that there are checks for proper input type for every input. This prevents the application from breaking if given an unexpected input. These checks are performed using while 
loops for the initial name and balance (since the program cannot continue until a proper name and balance are provided) as well as try/catch blocks for the deposit/withdrawl inputs.
