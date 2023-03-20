package com.example.testproject;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;

import com.google.android.material.snackbar.Snackbar;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.SaveCallback;

import com.example.testproject.databinding.FragmentSecondBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    Uri imageUri;
    Bitmap bitmap;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
                imageUri = Uri.parse(result);
                //binding.imageviewSecond.setImageURI(imageUri);
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), imageUri);
                    binding.imageviewSecond.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button1Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.button2Second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    File f = null;
                    FileOutputStream fos = null;
                    try {
                        f = new File(getContext().getCacheDir(), "image.jpg");
                        f.createNewFile();
                        fos = new FileOutputStream(f);
                        fos.write(bytes);
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (f != null) {
                        createObject(view, f);
                    }

                } else {
                    Toast.makeText(getContext(), "Select an image first", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void uploadImage() {
        if (imageUri == null) {
            return;
        }
    }

    public void createObject(View view, File f) {
        ParseFile file = new ParseFile(f);
        ParseObject entity = new ParseObject("Target");

        entity.put("description", "none");
        entity.put("image", file);

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    //Save was done
                    binding.button2Second.setEnabled(false);
                    Toast.makeText(getContext(), "Image uploaded", Toast.LENGTH_SHORT).show();
                    // Получение URL-адреса файла из объекта ParseFile
                    String fileUrl = file.getUrl();
                    // Вызов функции-обработчика и передача URL-адреса файла и получение ответа
                    processImage(file);
                } else {
                    //Something went wrong
                    Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void processImage(ParseFile file) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("image", file);

        ParseCloud.callFunctionInBackground("processImage", params, new FunctionCallback<String>() {
            @Override
            public void done(String result, ParseException e) {
                if (e == null) {
                    // Обработка результатов распознавания полимера
                    Log.d("Polymer recognition", "Result: " + result);
                } else {
                    // Обработка ошибки
                    Log.e("Polymer recognition", "Error: " + e.getMessage());
                }
            }
        });
    }

}