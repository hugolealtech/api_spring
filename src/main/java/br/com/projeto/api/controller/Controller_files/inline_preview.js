(function(g){var window=this;'use strict';var Psb=function(a){g.V.call(this,{I:"div",S:"ytp-inline-preview-ui"});this.C=!1;this.player=a;this.T(a,"onStateChange",this.z2);this.T(a,"videodatachange",this.A2);this.T(a,"onInlinePreviewModeChange",this.b8);this.B=new g.Ou(this.v2,null,this);g.N(this,this.B)},J6=function(a){g.OV.call(this,a);
this.j=new Psb(this.player);g.N(this,this.j);this.j.hide();g.zU(this.player,this.j.element,4);a.isInline()&&(this.load(),a=a.getRootNode(),g.Zu(a,["ytp-inline-preview-mode","ytp-no-contextmenu"]))};
g.w(Psb,g.V);g.k=Psb.prototype;
g.k.show=function(){g.Pu(this.B);if(!this.C){this.tooltip=new g.bY(this.player,this);g.N(this,this.tooltip);g.zU(this.player,this.tooltip.element,4);this.tooltip.scale=.6;this.Zd=new g.rW(this.player);g.N(this,this.Zd);this.j=new g.V({I:"div",La:["ytp-inline-preview-scrim"]});g.N(this,this.j);this.j.Ja(this.element);this.T(this.j.element,"click",this.w2);this.D=new g.VX(this.player,this,300);g.N(this,this.D);this.D.Ja(this.j.element);this.controls=new g.V({I:"div",S:"ytp-inline-preview-controls"});g.N(this,
this.controls);this.controls.Ja(this.element);var a=new g.nX(this.player,this,!1);g.N(this,a);a.Ja(this.controls.element);a=new g.TX(this.player,this);g.N(this,a);a.Ja(this.controls.element);this.progressBar=new g.uX(this.player,this);g.N(this,this.progressBar);g.zU(this.player,this.progressBar.element,4);this.T(this.player,"appresize",this.Yb);this.T(this.player,"fullscreentoggled",this.Yb);this.Yb();this.C=!0}0!==this.player.getPlayerState()&&g.V.prototype.show.call(this);this.progressBar.show();
this.player.kb("onInlinePreviewUiReady")};
g.k.hide=function(){this.B.stop();g.V.prototype.hide.call(this);this.player.isInline()||this.C&&this.progressBar.hide()};
g.k.xa=function(){g.V.prototype.xa.call(this)};
g.k.w2=function(a){a.target===this.j.element&&this.player.kb("onExpandInlinePreview",a)};
g.k.b8=function(){g.bv(this.player.getRootNode(),"ytp-inline-preview-mode",this.player.isInline())};
g.k.fg=function(){this.progressBar.Pc();this.D.Pc()};
g.k.v2=function(){this.fg();g.Pu(this.B)};
g.k.Yb=function(){g.r0a(this.progressBar,0,this.player.qb().getPlayerSize().width,!1);g.vX(this.progressBar)};
g.k.z2=function(a){this.player.isInline()&&(0===a?this.hide():this.show())};
g.k.A2=function(a,b){if(this.player.isInline()){g.bv(this.player.getRootNode(),"ytp-show-inline-preview-audio-controls",b.iC);var c,d,e;a=!(null==(e=null==(c=b.getPlayerResponse())?void 0:null==(d=c.playerConfig)?void 0:d.inlinePlaybackConfig)||!e.showScrubbingControls);g.bv(this.player.getRootNode(),"ytp-hide-inline-preview-progress-bar",!a)}};
g.k.Te=function(){return this.tooltip};
g.k.St=function(a,b,c,d,e){var f=d=0,h=0,l=g.qs(a);if(b){c=g.Xu(b,"ytp-mute-button");var m=g.Xu(b,"ytp-subtitles-button"),n=g.os(b,this.element);b=g.qs(b);d=n.y+40;if(m||c)h=n.x-l.width+b.width}else h=c-l.width/2,f=35;b=this.player.qb().getPlayerSize().width;h=g.ue(h,0,b-l.width);d?(a.style.top=d+(e||0)+"px",a.style.bottom=""):(a.style.top="",a.style.bottom=f+"px");a.style.left=h+"px"};g.w(J6,g.OV);J6.prototype.yl=function(){return!1};
J6.prototype.load=function(){this.player.hideControls();this.j.show()};
J6.prototype.unload=function(){this.player.showControls();this.j.hide()};g.NV("inline_preview",J6);})(_yt_player);
