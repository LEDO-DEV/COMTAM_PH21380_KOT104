package dolvph21380.fpoly.assignment_ph21380_kot104

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dolvph21380.fpoly.assignment_ph21380_kot104.ui.theme.Assignment_PH21380_KOT104Theme

data class Order(
    val id: String,
    val amount: String,
    val status: String
)

class TrangChu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment_PH21380_KOT104Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar() },
                    content = { paddingValues ->
                        MainContent(modifier = Modifier.padding(paddingValues))
                    }
                )
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val orders = listOf(
        Order("CTE2E2E", "162.000 đ", "Từ chối"),
        Order("CTE2E206", "157.000 đ", "Từ chối"),
        Order("CTE2E3E", "160.000 đ", "Chấp nhận"),
        Order("CTE2E12E", "160.000 đ", "Chấp nhận")
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color(0xFF1B1B1B)),
        verticalArrangement = Arrangement.Top
    ) {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        CartButton() // Add the cart button here
        Spacer(modifier = Modifier.height(16.dp))
        OrderList(orders)
    }
}

@Composable
fun CartButton() {

    val context = LocalContext.current

    Button(
        onClick = {

            Toast.makeText(context, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4CAF50),
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.cart),
            contentDescription = "Cart Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Thêm vào giỏ hàng")
    }
}

@Composable
fun Header() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Dashboard",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Today: 19-05-2023",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "Số lượng đơn: 4",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Text(
            text = "Doanh thu: 640.000 đ",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun OrderList(orders: List<Order>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(orders) { order ->
            OrderItem(order)
        }
    }
}

@Composable
fun OrderItem(order: Order) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF323232)),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.comtam),
                contentDescription = "Order Image",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Đơn hàng: ${order.id}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Số tiền: ${order.amount}",
                    fontSize = 16.sp,
                    color = Color.LightGray
                )
                Text(
                    text = "Trạng thái: ${order.status}",
                    fontSize = 16.sp,
                    color = if (order.status == "Chấp nhận") Color.Green else Color.Red
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFF2E2E2E),
        contentColor = Color.White,
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.home),
                    contentDescription = "Trang chủ"
                )
            },
            label = { Text("Trang chủ") },
            selected = true,
            onClick = {  },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Cyan,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Cyan,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.thongke),
                    contentDescription = "Thống kê"
                )
            },
            label = { Text("Thống kê") },
            selected = false,
            onClick = {  },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Cyan,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Cyan,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.quanly),
                    contentDescription = "Quản lý"
                )
            },
            label = { Text("Quản lý") },
            selected = false,
            onClick = { /* Navigate to Management */ },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Cyan,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Cyan,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painterResource(R.drawable.support1),
                    contentDescription = "Hỗ trợ"
                )
            },
            label = { Text("Hỗ trợ") },
            selected = false,
            onClick = {  },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Cyan,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Cyan,
                unselectedTextColor = Color.Gray
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TrangChuPreview() {
    Assignment_PH21380_KOT104Theme {
        MainContent()
    }
}
