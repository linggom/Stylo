<?php

sleep(1);

$lists = array(
	'Medium',
	'MediumItalic',
	'Light',
	'LightItalic',
	'Bold',
	'BoldItalic',
	'CondensedBlack',
	'CondensedBold'
);

foreach ($lists as $l) {
	echo "@font-face {
    font-family: 'HelveticaNeue-{$l}';
    src: url('HelveticaNeue-{$l}.eot');
    src: url('HelveticaNeue-{$l}.eot?#iefix') format('embedded-opentype'),
    url('HelveticaNeue-{$l}.svg#HelveticaNeue-{$l}') format('svg'),
    url('HelveticaNeue-{$l}.woff') format('woff'),
    url('HelveticaNeue-{$l}.ttf') format('truetype');
    font-weight: normal;
    font-style: normal;
}\n";
}