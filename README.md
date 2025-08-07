# How to show a toast message on all screens using snackbar in Jetpack Compose.
![1754555165985732](https://github.com/user-attachments/assets/a9240f96-66e9-47bd-a2d6-615c72f6b4be)

# Steps to implement custom snackbar from Main Activity

## Custom Snackbar Component
```
/**
 * This component is used to show custom toast
 * @param icon to display the icon on toast with message
 * @param message to display the message on toast
 */
@Composable
fun ComponentCustomSnackBar(@DrawableRes icon: Int, message: String) {
    Snackbar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        shape = RoundedCornerShape(5.dp),
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
            Spacer(modifier = Modifier.padding(end = 15.dp))
            Text(
                text = message,
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp.value.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}
```

## Inside the scaffold in the main activity

```
 val snackBarState = remember { SnackbarHostState() }
 val coroutineScope: CoroutineScope = rememberCoroutineScope()

Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        NavGraph(
                            navController, innerPadding,
                            showCustomSnackBar = { status, message ->
                                if (status){
                                    coroutineScope.launch {
                                        snackBarState.showSnackbar(message = message)
                                    }
                                }
                            }
                        )

                        SnackbarHost(
                            modifier = Modifier.align(Alignment.BottomStart), hostState = snackBarState
                        ) { data: SnackbarData ->
                            ComponentCustomSnackBar(
                                icon = R.drawable.ic_notification_icon_24,
                                data.visuals.message
                            )
                        }
                    }
                }
```

## Inside Nav Graph 
Inside the Nav Graph, we have to pass the showCustomSnackBar function as a parameter because it works from bottom to top flow.

```
@Composable
fun NavGraph(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues,
    showCustomSnackBar: (Boolean, String) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = NavRoute.HomeScreen,
        modifier = Modifier.padding(innerPaddingValues)
    ) {

        composable<NavRoute.HomeScreen>{
            HomeScreen(
                onClick = {
                    navHostController.navigate(NavRoute.DashboardScreen)
                },
                showToast = {
                    showCustomSnackBar(true, "Click from Home Screen")
                }
            )
        }

        composable<NavRoute.DashboardScreen>{
            DashboardScreen(
                onClick = {
                    navHostController.navigate(NavRoute.HomeScreen)
                },
                showToast = {
                    showCustomSnackBar(true, "Click from Dashboard Screen")
                }
            )
        }

    }

}
```

Follow our *ConnectU Edutech* page for more such useful tips and solutions on LinkedIn.
[ConnectU EduTech](https://www.linkedin.com/feed/update/urn:li:activity:7348633465619128320/?actorCompanyId=106688086)

If you have any thoughts or suggestions, please drop a comment with your suggestions.



