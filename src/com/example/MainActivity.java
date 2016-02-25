package com.example;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	ListView lista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// String[] tipo = new String[]{"Amigos", "Familia", "Trabalho"};
		String[] tipo = getResources().getStringArray(R.array.tipos);
		ArrayAdapter<String> aad = new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, tipo);
		lista = (ListView) findViewById(R.id.mTiposListView);
		lista.setAdapter(aad);
		lista.setOnClickListener(this);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	

    public void ondItemClick(AdapterView<?> o,View o1, int o2, long o3) {
    	if (lista.getSelectedItem() != null) {
			TextView status = (TextView) findViewById(R.id.mStatusTextView);
			String opcao = lista.getSelectedItem().toString();
			status.setText("Status: " + opcao);
		}

	}
   
    @Override
	public void onClick(View v) {
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}

}
