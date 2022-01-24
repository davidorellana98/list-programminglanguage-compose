package com.davidorellana.listprogramminglanguagecompose

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation

@Composable
fun ProgrammingLanguageListScreen(
    modifier: Modifier = Modifier,
    programmingLanguageList: List<ProgrammingLanguage>
) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Lenguajes De Programación",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.Cursive
                )
            }
        }

        items(programmingLanguageList) { programmingLanguage ->
            ProgrammingLanguageCard(
                nameLanguage = programmingLanguage.nameLanguage,
                author = programmingLanguage.author,
                creation = programmingLanguage.yearCreation,
                paradigm = programmingLanguage.paradigm,
                website = programmingLanguage.website,
                photoLogo = programmingLanguage.photoLogo
            )
        }
    }
}

@Composable
fun ProgrammingLanguageCard(
    modifier: Modifier = Modifier,
    nameLanguage: String,
    author: String,
    creation: Int,
    paradigm: String,
    website: String,
    photoLogo: String
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(20.dp)),
        elevation = 5.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = photoLogo,
                    builder = {
                        transformations(RoundedCornersTransformation(10f))
                    }
                ),
                contentDescription = null,
                modifier = modifier
                    .padding(start = 10.dp)
                    .size(90.dp)
            )

            Divider(
                modifier = modifier
                    .padding(start = 10.dp)
                    .width(2.dp)
                    .height(120.dp)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .padding(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Text(
                        text = nameLanguage,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )

                    Spacer(modifier = modifier.width(10.dp))

                    val context = LocalContext.current
                    Surface(
                        modifier = modifier.clickable {
                            val urlAddress: Uri = Uri.parse(website)
                            val intent = Intent(Intent.ACTION_VIEW, urlAddress)
                            startActivity(context, intent, Bundle.EMPTY)
                        },
                        shape = MaterialTheme.shapes.medium,
                        elevation = 4.dp
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Public,
                            contentDescription = null,
                            modifier = modifier.size(40.dp)
                        )
                    }
                }

                Text(text = "Autor: $author")
                Text(text = "Apareció: $creation")
                Text(text = "Paradigma: $paradigm")
            }
        }
    }
}