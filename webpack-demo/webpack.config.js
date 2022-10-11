const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    name: 'config',
    mode: 'development',
    entry: {
        index: './src/index.js',
    },
    devServer: {
        static: './dist',
        hot: true,
    },
    devtool: 'inline-source-map',
    plugins: [
        new HtmlWebpackPlugin({
            title: 'react with webpack',
        })
    ],
    module: {
        rules: [
            {
                test: /\.jsx?$/, // 用正则来匹配文件路径，这段意思是匹配 js 或者 jsx
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: [
                            '@babel/preset-env', 
                            ["@babel/preset-react", {"runtime": "automatic"}]
                        ]
                    }
                }
            }
        ]
    },
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, 'dist'),
        clean: true,
        publicPath: '/'
    },
    optimization: {
        runtimeChunk: 'single',
    },
};
