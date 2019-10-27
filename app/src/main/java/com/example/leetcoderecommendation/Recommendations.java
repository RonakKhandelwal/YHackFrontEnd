package com.example.leetcoderecommendation;

import Networking.Callback;
import Networking.Modals.QuestionDetailsModal;
import Utils.NetworkTask;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewCallback;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.leocardz.link.preview.library.LinkPreviewCallback;
import com.leocardz.link.preview.library.SourceContent;
import com.leocardz.link.preview.library.TextCrawler;

public class Recommendations extends Fragment {

    private RecommendationsViewModel mViewModel;

    public static Recommendations newInstance() {
        return new Recommendations();
    }

    TextCrawler textCrawler = new TextCrawler();
    private Bitmap[] currentImageSet;
    private Bitmap currentImage;

    TextView titleTextView, urlTextView, descriptionTextView;
    String target_url = "https://leetcode.com/problems/distribute-coins-in-binary-tree/";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(RecommendationsViewModel.class);
        final View root = inflater.inflate(R.layout.recommendations_fragment, container, false);

        final LinearLayout infoWrap = root
                .findViewById(R.id.info_wrap);
        infoWrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(target_url));
                startActivity(browserIntent);
            }
        });
        final LinearLayout titleWrap = infoWrap
                .findViewById(R.id.title_wrap);
        final LinearLayout thumbnailOptions = root
                .findViewById(R.id.thumbnail_options);
//                final LinearLayout noThumbnailOptions = content
//                        .findViewById(R.id.no_thumbnail_options);

//                final ImageView imageSet = content
//                        .findViewById(R.id.image_post_set);

        titleTextView = titleWrap
                .findViewById(R.id.title);
        final EditText titleEditText = titleWrap
                .findViewById(R.id.input_title);
        urlTextView = root
                .findViewById(R.id.url);
        descriptionTextView = root
                .findViewById(R.id.description);
        final EditText descriptionEditText = root
                .findViewById(R.id.input_description);
        final TextView countTextView = thumbnailOptions
                .findViewById(R.id.count);



        final LinkPreviewCallback linkPreviewCallback = new LinkPreviewCallback() {

            private View mainView;
            private LinearLayout linearLayout;
            private View loading;
            private ImageView imageView;

            @Override
            public void onPre() {
                // Any work that needs to be done before generating the preview. Usually inflate
                // your custom preview layout here.
            }

            @Override
            public void onPos(SourceContent sourceContent, boolean b) {
                // Populate your preview layout with the results of sourceContent.

                currentImageSet = new Bitmap[sourceContent.getImages().size()];

                /**
                 * Inflating the content layout into Main View LinearLayout
                 */
                final View content = getLayoutInflater().inflate(
                        R.layout.preview_content, linearLayout);

                /** Fullfilling the content layout */
                final LinearLayout infoWrap = content
                        .findViewById(R.id.info_wrap);
                final LinearLayout titleWrap = infoWrap
                        .findViewById(R.id.title_wrap);
                final LinearLayout thumbnailOptions = content
                        .findViewById(R.id.thumbnail_options);
//                final LinearLayout noThumbnailOptions = content
//                        .findViewById(R.id.no_thumbnail_options);

//                final ImageView imageSet = content
//                        .findViewById(R.id.image_post_set);

                final TextView titleTextView = titleWrap
                        .findViewById(R.id.title);
                final EditText titleEditText = titleWrap
                        .findViewById(R.id.input_title);
                final TextView urlTextView = content
                        .findViewById(R.id.url);
                final TextView descriptionTextView = content
                        .findViewById(R.id.description);
                final EditText descriptionEditText = content
                        .findViewById(R.id.input_description);
                final TextView countTextView = thumbnailOptions
                        .findViewById(R.id.count);
//                final CheckBox noThumbCheckBox = noThumbnailOptions
//                        .findViewById(R.id.no_thumbnail_checkbox);
                final Button previousButton = thumbnailOptions
                        .findViewById(R.id.post_previous);
                final Button forwardButton = thumbnailOptions
                        .findViewById(R.id.post_forward);

                /*
                titleTextView.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        titleTextView.setVisibility(View.GONE);

                        titleEditText.setText(TextCrawler
                                .extendedTrim(titleTextView.getText()
                                        .toString()));
                        titleEditText.setVisibility(View.VISIBLE);
                    }
                });

                titleEditText
                        .setOnEditorActionListener(new OnEditorActionListener() {

                            @Override
                            public boolean onEditorAction(TextView arg0,
                                                          int arg1, KeyEvent arg2) {

                                if (arg2.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                                    titleEditText.setVisibility(View.GONE);

                                    currentTitle = TextCrawler
                                            .extendedTrim(titleEditText
                                                    .getText().toString());

                                    titleTextView.setText(currentTitle);
                                    titleTextView.setVisibility(View.VISIBLE);

                                    hideSoftKeyboard();
                                }

                                return false;
                            }
                        });
                descriptionTextView.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        descriptionTextView.setVisibility(View.GONE);

                        descriptionEditText.setText(TextCrawler
                                .extendedTrim(descriptionTextView.getText()
                                        .toString()));
                        descriptionEditText.setVisibility(View.VISIBLE);
                    }
                });
                descriptionEditText
                        .setOnEditorActionListener(new OnEditorActionListener() {

                            @Override
                            public boolean onEditorAction(TextView arg0,
                                                          int arg1, KeyEvent arg2) {

                                if (arg2.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                                    descriptionEditText
                                            .setVisibility(View.GONE);

                                    currentDescription = TextCrawler
                                            .extendedTrim(descriptionEditText
                                                    .getText().toString());

                                    descriptionTextView
                                            .setText(currentDescription);
                                    descriptionTextView
                                            .setVisibility(View.VISIBLE);

                                    hideSoftKeyboard();
                                }

                                return false;
                            }
                        });

                close.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        releasePreviewArea();
                    }
                });

                noThumbCheckBox
                        .setOnCheckedChangeListener(new OnCheckedChangeListener() {

                            @Override
                            public void onCheckedChanged(CompoundButton arg0,
                                                         boolean arg1) {
                                noThumb = arg1;

                                if (sourceContent.getImages().size() > 1)
                                    if (noThumb)
                                        thumbnailOptions
                                                .setVisibility(View.GONE);
                                    else
                                        thumbnailOptions
                                                .setVisibility(View.VISIBLE);

                                showHideImage(imageSet, infoWrap, !noThumb);
                            }
                        });

                previousButton.setEnabled(false);
                previousButton.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        if (currentItem > 0)
                            changeImage(previousButton, forwardButton,
                                    currentItem - 1, sourceContent,
                                    countTextView, imageSet, sourceContent
                                            .getImages().get(currentItem - 1),
                                    currentItem);
                    }
                });
                forwardButton.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        if (currentItem < sourceContent.getImages().size() - 1)
                            changeImage(previousButton, forwardButton,
                                    currentItem + 1, sourceContent,
                                    countTextView, imageSet, sourceContent
                                            .getImages().get(currentItem + 1),
                                    currentItem);
                    }
                });

                */

                if (sourceContent.getImages().size() > 0) {

                    if (sourceContent.getImages().size() > 1) {
                        countTextView.setText("1 " + getString(R.string.of)
                                + " " + sourceContent.getImages().size());

                        thumbnailOptions.setVisibility(View.VISIBLE);
                    }
//                    noThumbnailOptions.setVisibility(View.VISIBLE);

//                    UrlImageViewHelper.setUrlDrawable(imageSet, sourceContent
//                            .getImages().get(0), new UrlImageViewCallback() {
//
//                        @Override
//                        public void onLoaded(ImageView imageView,
//                                             Bitmap loadedBitmap, String url,
//                                             boolean loadedFromCache) {
//                            if (loadedBitmap != null) {
//                                currentImage = loadedBitmap;
//                                currentImageSet[0] = loadedBitmap;
//                            }
//                        }
//                    });

                }
//                else {
//                    showHideImage(imageSet, infoWrap, false);
//                }

                if (sourceContent.getTitle().equals(""))
                    sourceContent.setTitle(getString(R.string.enter_title));
                if (sourceContent.getDescription().equals(""))
                    sourceContent
                            .setDescription(getString(R.string.enter_description));

                titleTextView.setText(sourceContent.getTitle());
                urlTextView.setText(sourceContent.getCannonicalUrl());
                descriptionTextView.setText(sourceContent.getDescription());

                if (root instanceof CardView) {
                    CardView cardView = (CardView) root;
                    Log.d("YHack", "here" + sourceContent.getUrlData()[0] + sourceContent.getUrlData()[1]);
                    cardView.removeAllViews();
                    cardView.addView(content);
                }

            }
        };



        NetworkTask.getNextQuestion(new Callback<QuestionDetailsModal>() {

            @Override
            public void returnResult(QuestionDetailsModal questionDetailsModal) {
                if (null == questionDetailsModal) {
                    return;
                }
//                textCrawler.makePreview(linkPreviewCallback, questionDetailsModal.getUrl());
                if (questionDetailsModal.getTitle().equals(""))
                    questionDetailsModal.setTitle(getString(R.string.enter_title));
                if (questionDetailsModal.getDescription().equals(""))
                    questionDetailsModal
                            .setDescription(getString(R.string.enter_description));

                titleTextView.setText(questionDetailsModal.getTitle());
                urlTextView.setText(questionDetailsModal.getUrl());
                descriptionTextView.setText(Html.fromHtml(questionDetailsModal.getDescription()));
                target_url = questionDetailsModal.getUrl();
            }

            @Override
            public void returnError(String message) {
                Log.e("Recommendations", message);
            }
        });


        return root;
        //return inflater.inflate(R.layout.recommendations_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RecommendationsViewModel.class);
        // TODO: Use the ViewModel
    }

}
