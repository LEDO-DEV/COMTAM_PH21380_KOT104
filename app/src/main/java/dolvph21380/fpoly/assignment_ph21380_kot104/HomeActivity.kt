package dolvph21380.fpoly.assignment_ph21380_kot104

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dolvph21380.fpoly.assignment_ph21380_kot104.ui.theme.Assignment_PH21380_KOT104Theme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_PH21380_KOT104Theme {
                MainScreen(this)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context: HomeActivity) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Tiệm Cơm Tấm", fontSize = 20.sp) })
        },
        bottomBar = {
            BottomNavigationBar(context)
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF2E2E2E))
            ) {
                item { MenuItem("Thêm món ăn") }
                item { MenuItem("Sửa món ăn") }
                item { MenuItem("Xóa món ăn") }
            }
        }
    )
}

@Composable
fun MenuItem(title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.order),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(context: HomeActivity) {
    NavigationBar(
        containerColor = Color(0xFF2E2E2E),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.home),
                    contentDescription = "Trang chủ",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    "Trang chủ",
                    fontSize = 10.sp
                )
            },
            selected = false,
            onClick = {

                val intent = Intent(context, TrangChu::class.java)
                context.startActivity(intent)
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.thongke),
                    contentDescription = "Lịch Sử",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    "Lịch Sử",
                    fontSize = 10.sp
                )
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.quanly),
                    contentDescription = "Giỏ Hàng",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    "Giỏ Hàng",
                    fontSize = 10.sp
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.support1),
                    contentDescription = "Hồ Sơ",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    "Hồ Sơ",
                    fontSize = 10.sp
                )
            },
            selected = false,
            onClick = {

                val intent = Intent(context, HoTro::class.java)
                context.startActivity(intent)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Assignment_PH21380_KOT104Theme {
        MainScreen(HomeActivity())
    }
}
