package com.example.inshortsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HomeApp(modifier: Modifier = Modifier,viewModel: NewsViewModel) {
    val res = viewModel.res.value?.articles!!

    var searchtext by remember {
        mutableStateOf("")
    }
    Column {

        TextField(value = searchtext, onValueChange ={ newtext ->
                 searchtext = newtext

        },
            placeholder = {Text(text =  "Search...")},
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Phone")
                }
            }, trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Send, contentDescription = "Phone")
                }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 12.dp, start = 20.dp, end = 20.dp)
                .clip(RoundedCornerShape(12.dp))

        )
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(res) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(170.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray)
            ) {


                    Box {
                        AsyncImage(
                            model = it.urlToImage,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = it.title,
                            color = Color.White,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(4.dp)
                        )
//                    if (!it.publishedAt.isNullOrEmpty())
//                        Text(
//                            text = it.publishedAt,
//                            color = Color.White,
//                            fontWeight = FontWeight.Bold,
//                            modifier = Modifier
//                                .align(Alignment.BottomEnd)
//                                .padding(end = 4.dp, bottom = 4.dp)
//                        )
                        if (!it.author.isNullOrEmpty())
                            Text(
                                text = it.author,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .padding(end = 4.dp, bottom = 4.dp)
                            )


                    }
                }
            }

        }

    }
}