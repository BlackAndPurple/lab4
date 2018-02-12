var path = require('path');
var webpack = require('webpack');

module.exports = {
    devtool: 'eval-source-map',
    entry: {
        "SignUp": "./web/react/components/SignUpForm.js",
        "SignIn": "./web/react/components/SignInForm.js",
        "MainPage":"./web/react/components/CoordForm.js"
    }, // входная точка - исходный файл
    output:{
        path: path.resolve(__dirname, './web/public'),     // путь к каталогу выходных файлов - папка public
        publicPath: '/',
        filename: "[name]-bundle.js"       // название создаваемого файла
    },
    module:{
        rules:[   //загрузчик для jsx
            {
                test: /\.jsx?$/, // определяем тип файлов
                exclude: /(node_modules)/,  // исключаем из обработки папку node_modules
                loader: "babel-loader",   // определяем загрузчик
                options:{
                    presets:["env", "react"]    // используемые плагины
                }
            }
        ]
    }
}