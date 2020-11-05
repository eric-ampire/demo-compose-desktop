import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ericampire.DrawerItem

@Composable
fun DrawerItemView(menuItem: DrawerItem) {
    Column {
        Row(
            modifier = Modifier.Companion.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            children = {
                Icon(
                    asset = menuItem.icon,
                    tint = Color.Gray,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(text = menuItem.title)
            }
        )
    }
}


@Composable
fun DrawerView(data: List<DrawerItem>) {
    val icon = 2

    LazyColumnFor(data, modifier = Modifier.preferredWidth(180.dp)) {
        DrawerItemView(it)
    }
}

fun main() {
    val color = "#fff"
    Window(
        title = "Compose for Desktop",
        content = {
            val data = listOf(
                DrawerItem(
                    icon = Icons.Rounded.Home,
                    title = "Home"
                ),
                DrawerItem(
                    icon = Icons.Rounded.Home,
                    title = "Explore"
                ),
                DrawerItem(
                    icon = Icons.Rounded.Notifications,
                    title = "Notifications"
                ),
                DrawerItem(
                    icon = Icons.Rounded.Email,
                    title = "Messages"
                ),
                DrawerItem(
                    icon = Icons.Rounded.MailOutline,
                    title = "Bookmarks"
                ),
                DrawerItem(
                    icon = Icons.Rounded.List,
                    title = "List"
                )
            )

            Row {
                Column {
                    DrawerView(data)

                    Button(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .preferredWidth(150.dp)
                            .padding(top = 10.dp)
                            .align(Alignment.CenterHorizontally),
                        onClick = {

                        },
                        content = {
                            Text("Button")
                        }
                    )
                }
                Divider(modifier = Modifier.width(1.dp).fillMaxHeight())
            }
        }
    )
}

