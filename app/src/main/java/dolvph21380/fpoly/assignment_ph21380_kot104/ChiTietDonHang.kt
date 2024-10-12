package dolvph21380.fpoly.assignment_ph21380_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dolvph21380.fpoly.assignment_ph21380_kot104.ui.theme.Assignment_PH21380_KOT104Theme

class ChiTietDonHang : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment_PH21380_KOT104Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFE0E0))
                ) { innerPadding ->
                    OrderDetailScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun OrderDetailScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Chi tiết đơn hàng",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )


        Text(text = "Tiệm Cơm Tấm", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = "110 Tô Ký, P.Trung Mỹ Tây, Ha Noi City")
        Text(text = "0369790880")
        Text(
            text = "Hóa Đơn Thanh Toán",
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(text = "Ngày: 16-05-2023")
        Text(text = "Trạng thái đơn hàng: Đã thanh toán", color = Color.Green)

        Spacer(modifier = Modifier.height(16.dp))


        OrderDetailItem(label = "Số lượng món chính:", value = "3")
        OrderDetailItem(label = "+Sườn mỡ:", value = "0")
        OrderDetailItem(label = "+Sườn:", value = "3")
        OrderDetailItem(label = "Tổng tiền món chính:", value = "75k")
        OrderDetailItem(label = "Số lượng món thêm:", value = "0")
        OrderDetailItem(label = "Số lượng món topping:", value = "0")
        OrderDetailItem(label = "Số lượng món khác:", value = "0")
        OrderDetailItem(label = "Tổng số lượng:", value = "3")

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Số nhà: 22/333\nĐường: Trung Mỹ Tây 1\nPhường: Tân Thới Nhất\nQuận: 12\nThành Phố: Hồ Chí Minh",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Tổng tiền", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "75", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun OrderDetailItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 16.sp)
        Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun OrderDetailPreview() {
    Assignment_PH21380_KOT104Theme {
        OrderDetailScreen()
    }
}
