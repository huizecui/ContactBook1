/**
 * Name:Huize Cui
 * Course:CS40S
 * Teacher:Mr.Hardman
 * Lab #3,Program.1
 * Date Last Modified: 4/10/18
 */
package comhuizecui.httpsgithub.contactbook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static Contact[] contactArray;
    private static int numContactsAdded;
    private TextView mErrorMessage;
    private TextView mSortedLists;
    private EditText mNameInput;
    private EditText mPhoneInputs;
    private EditText mEmailnput;

    private int insertionStepe = 0;
    private  int selectionsteps = 0;
    private  int quickSteps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameInput = (EditText) findViewById(R.id.et_name) ;
        mPhoneInputs = (EditText) findViewById(R.id.et_phone);
        mEmailnput = (EditText) findViewById(R.id.et_e_mail);

        contactArray = new Contact[50];
        numContactsAdded = 0;
    }

    private void addTheContact(View vw)
    {
        InputMethodManager inputManager = (InputMethodManager ) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        Contact userInput;

        if( inputManager != null )
        {
            inputManager.hideSoftInputFromWindow(vw.getApplicationWindowToken(), 0);
        }

        if (numContactsAdded <= 0)
        {
            mErrorMessage.setText("You must enter at least a name to add a contact.");
        }
        if( numContactsAdded >= 50 )
        {
            mErrorMessage.setText( "You have added the maximum amount of contacts." );

            if( inputManager != null )
            {
                inputManager.hideSoftInputFromWindow(vw.getApplicationWindowToken(), 0);
            }
        }
        else
        {
            numContactsAdded++;

            mErrorMessage.setText( "Contact added successfully!" );
        }

        String nameInput;
        String phoneInput;
        String emailInput;

        numContactsAdded++;
    }

    private void sortContacts()
    {
        String storeList = "";

        mErrorMessage.setText("");
        mSortedLists.setText(storeList);

    }
    private String insertionSort()
    {
        //you will not need this for your assiqnment
        double[] temp = new double[10];

        //you will not need this
        String result;


        //key might need to be a different data type...
        double key;
        int index;


        //this is where insertion sort starts
        for ( int j = 1; j < temp.length; j++ )
        {
            key = temp[j];
            index = j-1;

            while (index >= 0 && temp[index] > key )
            {
                temp[index+1] = temp[index];
                index = index - 1;

                insertionStepe++;
            }

            temp[index+1 ] = key;

            insertionStepe++;
        }

        result = "Insertion Sort Result:\n";

        for ( int k = 0; k < temp.length; k++ )
        {
            result += temp[k] + ", \t";
        }

        result += "\nThis took " + insertionStepe + " steps to complete,\n\n";


        return result;
    }

    /**
     * insertionSort uses the Insertion Sort algorithm to sort a list of items
     * in ascending order
     * @param "" There are no parameters
     * @return a String that displays the sorted list and how ,amy steps it took
     */
    private String selectionSort(View vw)
    {
        double[] temp = new double[10];

        String result;

        int minIndex;
        double toSwap;

        for( int j = 0; j < temp.length - 1; j++ )
        {
            minIndex = j;

            for ( int k = j+1; k < temp.length; k++)
            {
                if ( temp[k] < temp[minIndex] )
                {
                    minIndex = k;
                }

                selectionsteps++;
            }

            toSwap = temp[minIndex];
            temp[minIndex] = temp[j];
            temp[j] = toSwap;

            selectionsteps++;
        }

        result = "Selection Sort Result:\n";

        for ( int m =0; m < temp.length; m++ )
        {
            result += temp[m] + ", \t";

        }

        result +="\nThis took " + selectionsteps + " steps to complete.\n\n";

        return result;
    }

    /**
     * quickSort uses the Quick Sort algorithm to sort a list in
     * ascending order
     *
     * @param array is the array we are sorting
     * @param low is the beginning index of the section of the array we would like
     *            to sort
     * @param high is the ending index of the section of the array we would like
     *             to sort
     * @return Nothing is returned
     */

    private void quickSort( double[] array, int low, int high )
    {
        int middle;
        double pivot;

        int i;
        int j;

        double toSwap;

        if( low < high )
        {
            middle = low + (high - low ) / 2;
            pivot = array[middle];

            i=low;
            j=high;

            while( i <= j )
            {
                while (array[i] < pivot )
                {
                    i++;

                    quickSteps++;

                }

                while (array[j] > pivot )
                {
                    j--;

                    quickSteps++;
                }

                if ( i <= j )
                {
                    toSwap = array[i];
                    array[i] = array[j];
                    array[j] = toSwap;
                    i++;
                    j--;
                }

                quickSteps++;
            }

            if ( low < j )
            {
                quickSort( array, low, j );

                quickSteps++;
            }

            if ( high > i )
            {
                quickSort( array, i, high );

                quickSteps++;
            }
        }

        quickSteps++;
    }


}
