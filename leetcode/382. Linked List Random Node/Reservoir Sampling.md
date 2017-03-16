<html lang="en"><head>
    <meta charset="UTF-8">
    <title></title>
<style id="system" type="text/css">*{margin:0;padding:0;}body {	font:13.34px helvetica,arial,freesans,clean,sans-serif;	color:black;	line-height:1.4em;	background-color: #F8F8F8;	padding: 0.7em;}p {	margin:1em 0;	line-height:1.5em;}table {	font-size:inherit;	font:100%;	margin:1em;}table th{border-bottom:1px solid #bbb;padding:.2em 1em;}table td{border-bottom:1px solid #ddd;padding:.2em 1em;}input[type=text],input[type=password],input[type=image],textarea{font:99% helvetica,arial,freesans,sans-serif;}select,option{padding:0 .25em;}optgroup{margin-top:.5em;}pre,code{font:12px Monaco,"Courier New","DejaVu Sans Mono","Bitstream Vera Sans Mono",monospace;}pre {	margin:1em 0;	font-size:12px;	background-color:#eee;	border:1px solid #ddd;	padding:5px;	line-height:1.5em;	color:#444;	overflow:auto;	-webkit-box-shadow:rgba(0,0,0,0.07) 0 1px 2px inset;	-webkit-border-radius:3px;	-moz-border-radius:3px;border-radius:3px;white-space: pre-wrap;word-wrap:break-word;}pre code {	padding:0;	font-size:12px;	background-color:#eee;	border:none;}code {	font-size:12px;	background-color:#f8f8ff;	color:#444;	padding:0 .2em;	border:1px solid #dedede;}img{border:0;max-width:100%;}abbr{border-bottom:none;}a{color:#4183c4;text-decoration:none;}a:hover{text-decoration:underline;}a code,a:link code,a:visited code{color:#4183c4;}h2,h3{margin:1em 0;}h1,h2,h3,h4,h5,h6{border:0;}h1{font-size:170%;border-top:4px solid #aaa;padding-top:.5em;margin-top:1.5em;}h1:first-child{margin-top:0;padding-top:.25em;border-top:none;}h2{font-size:150%;margin-top:1.5em;border-top:4px solid #e0e0e0;padding-top:.5em;}h3{margin-top:1em;}hr{border:1px solid #ddd;}ul{margin:1em 0 1em 2em;}ol{margin:1em 0 1em 2em;}ul li,ol li{margin-top:.5em;margin-bottom:.5em;}ul ul,ul ol,ol ol,ol ul{margin-top:0;margin-bottom:0;}blockquote{margin:1em 0;border-left:5px solid #ddd;padding-left:.6em;color:#555;}dt{font-weight:bold;margin-left:1em;}dd{margin-left:2em;margin-bottom:1em;}@media screen and (min-width: 768px) {    body {        width: 748px;        margin:10px auto;    }}</style><style id="custom" type="text/css"></style></head>
<body marginheight="0"><p>从一个包含n个对象的列表S中随机选取k个对象，n为一个非常大或者不知道的值。通常情况下，n是一个非常大的值，大到无法一次性把所有列表S中的对象都放到内存中。我们这个问题是蓄水池抽样问题的一个特例，即k=1。

</p>
<p>  <strong>解法：</strong>我们总是选择第一个对象，以1/2的概率选择第二个，以1/3的概率选择第三个，以此类推，以1/m的概率选择第m个对象。当该过程结束时，每一个对象具有相同的选中概率，即1/n，证明如下。

</p>
<p>  <strong>证明：</strong>
第m个对象最终被选中的概率P=选择m的概率*其后面所有对象不被选择的概率，


</p>
<center><img src="http://upload-images.jianshu.io/upload_images/5238294-6b09c69c78e0c19d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt=""></center>

<p>  对应<strong>蓄水池抽样问题</strong>，可以类似的思路解决。先把读到的前k个对象放入“水库”，对于第k+1个对象开始，以k/(k+1)的概率选择该对象，以k/(k+2)的概率选择第k+2个对象，以此类推，以k/m的概率选择第m个对象（m&gt;k）。如果m被选中，则随机替换水库中的一个对象。最终每个对象被选中的概率均为k/n，证明如下。
&nbsp; &nbsp;证明：<em>*第m个对象被选中的概率=选择m的概率</em>（其后元素不被选择的概率+其后元素被选择的概率*不替换第m个对象的概率），即
</p>
<p></p><center><img src="http://upload-images.jianshu.io/upload_images/5238294-d33da8d034bb6f62.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt=""></center>
Edit By <a href="http://mahua.jser.me">MaHua</a><p></p>
</body></html>