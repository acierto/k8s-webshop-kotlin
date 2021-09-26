const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require("path");

module.exports = {
    mode: "development",
    devtool: "source-map",
    entry: './src/index.tsx',
    module: {
        rules: [
            {
                test: /\.(ts|tsx)?$/,
                loader: "awesome-typescript-loader",
                exclude: /node_modules/
            },
            {
                test: /\.css$/i,
                use: ["style-loader", "css-loader"],
            },
            {
                test: /\.(jpg|jpeg|png|gif|mp3|svg)$/,
                use: ["file-loader"],
            },
            {
                test: /\.js$/,
                exclude: /(node_modules)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
        ]
    },
    resolve: {
        extensions: ['.ts', '.js', '.json', ".tsx"]
    },
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, 'dist'),
        clean: true,
    },
    devServer: {
        port: 4000,
        open: true,
        hot: true,
        static: './build',
        proxy: {
            '/graphql': 'http://localhost:8888',
        },
    },

    plugins: [new HtmlWebpackPlugin({
        template: "public/index.html",
        hash: true, // This is useful for cache busting
        filename: 'index.html'
    })]
}
