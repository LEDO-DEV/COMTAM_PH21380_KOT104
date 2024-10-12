package dolvph21380.fpoly.assignment_ph21380_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dolvph21380.fpoly.assignment_ph21380_kot104.ui.theme.Assignment_PH21380_KOT104Theme

class ManHinhThanhToan : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment_PH21380_KOT104Theme {
                ManHinhThanhToanScreen()
            }
        }
    }
}

@Composable
fun ManHinhThanhToanScreen() {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            CustomerInfoCard()


            PaymentInfoCard()


            PaymentActionCard(onPayClicked = { showDialog = true })
        }


        if (showDialog) {
            ConfirmPaymentDialog(
                onDismiss = { showDialog = false },
                onConfirm = {  }
            )
        }
    }
}

@Composable
fun CustomerInfoCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Thông tin khách hàng", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Tên: Nguyễn Văn A")
            Text(text = "Điện thoại: 0901234567")
            Text(text = "Địa chỉ: 123 Đường ABC, TP. Hồ Chí Minh")
        }
    }
}

@Composable
fun PaymentInfoCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Thông tin thanh toán", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Phương thức: Thanh toán khi nhận hàng")
            Text(text = "Sản phẩm: Điện thoại XYZ")
            Text(text = "Giá: 10.000.000 VNĐ")
        }
    }
}

@Composable
fun PaymentActionCard(onPayClicked: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Tổng tiền: 10.000.000 VNĐ", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onPayClicked) {
                Text(text = "Thanh toán")
            }
        }
    }
}

@Composable
fun ConfirmPaymentDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Xác nhận thanh toán") },
        text = { Text(text = "Bạn có chắc chắn muốn thanh toán?") },
        confirmButton = {
            Button(onClick = {
                onConfirm()
                onDismiss()
            }) {
                Text(text = "Thanh toán")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Mua tiếp")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ManHinhThanhToanPreview() {
    Assignment_PH21380_KOT104Theme {
        ManHinhThanhToanScreen()
    }
}
