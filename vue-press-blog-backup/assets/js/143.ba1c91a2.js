(window.webpackJsonp=window.webpackJsonp||[]).push([[143],{347:function(e,t,o){"use strict";o.r(t);var n=o(0),r=Object(n.a)({},(function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("ContentSlotsDistributor",{attrs:{"slot-key":e.$parent.slotKey}},[o("h1",{attrs:{id:"oauth2"}},[o("a",{staticClass:"header-anchor",attrs:{href:"#oauth2"}},[e._v("#")]),e._v(" OAuth2")]),e._v(" "),o("div",{staticClass:"custom-block tip"},[o("p",{staticClass:"custom-block-title"},[e._v("official web site")]),e._v(" "),o("p",[o("a",{attrs:{href:"https://oauth.net/2/",target:"_blank",rel:"noopener noreferrer"}},[e._v("oauth2"),o("OutboundLink")],1)])]),e._v(" "),o("h2",{attrs:{id:"what-is-oauth2"}},[o("a",{staticClass:"header-anchor",attrs:{href:"#what-is-oauth2"}},[e._v("#")]),e._v(" What is oauth2")]),e._v(" "),o("pre",[o("code",[e._v("official explaination:\n    The OAuth 2.0 authorization framework enables a third-party\n    application to obtain limited access to an HTTP service, either on\n    behalf of a resource owner by orchestrating an approval interaction\n    between the resource owner and the HTTP service, or by allowing the\n    third-party application to obtain access on its own behalf.\n    \nsimplicity:\n    we don't have to give our username & password to third-party application\n    we just give the access_token and limit third-party's permission.\n")])]),e._v(" "),o("h3",{attrs:{id:"roles"}},[o("a",{staticClass:"header-anchor",attrs:{href:"#roles"}},[e._v("#")]),e._v(" Roles")]),e._v(" "),o("div",{staticClass:"custom-block tip"},[o("p",{staticClass:"custom-block-title"},[e._v("Four Roles")]),e._v(" "),o("p",[o("strong",[e._v("1. resource ownder")])]),e._v(" "),o("pre",[o("code",[e._v("give access_token to someone else\n")])]),e._v(" "),o("p",[o("strong",[e._v("2. resource server")])]),e._v(" "),o("pre",[o("code",[e._v("response to request with access_token\n")])]),e._v(" "),o("p",[o("strong",[e._v("3. client")])]),e._v(" "),o("pre",[o("code",[e._v("application which need authorization\n")])]),e._v(" "),o("p",[o("strong",[e._v("4. authorization server")])]),e._v(" "),o("pre",[o("code",[e._v("give access_token to client\n")])])]),e._v(" "),o("h3",{attrs:{id:"protocol-flow"}},[o("a",{staticClass:"header-anchor",attrs:{href:"#protocol-flow"}},[e._v("#")]),e._v(" Protocol Flow")]),e._v(" "),o("pre",[o("code",[e._v(" +--------+                               +---------------+\n |        |--(A)- Authorization Request ->|   Resource    |\n |        |                               |     Owner     |\n |        |<-(B)-- Authorization Grant ---|               |\n |        |                               +---------------+\n |        |\n |        |                               +---------------+\n |        |--(C)-- Authorization Grant --\x3e| Authorization |\n | Client |                               |     Server    |\n |        |<-(D)----- Access Token -------|               |\n |        |                               +---------------+\n |        |\n |        |                               +---------------+\n |        |--(E)----- Access Token ------\x3e|    Resource   |\n |        |                               |     Server    |\n |        |<-(F**--- Protected Resource --|               |\n +--------+                               +---------------+\n")])]),e._v(" "),o("h3",{attrs:{id:"authorization-grant"}},[o("a",{staticClass:"header-anchor",attrs:{href:"#authorization-grant"}},[e._v("#")]),e._v(" Authorization Grant")]),e._v(" "),o("pre",[o("code",[e._v("used to get an access token.\n")])]),e._v(" "),o("div",{staticClass:"custom-block tip"},[o("p",{staticClass:"custom-block-title"},[e._v("Four Grant Types")]),e._v(" "),o("p",[o("strong",[e._v("1. Authorization Code")])]),e._v(" "),o("p",[o("strong",[e._v("2.Implicit")])]),e._v(" "),o("p",[o("strong",[e._v("3.Resource Owner Password Credentials")])]),e._v(" "),o("p",[o("strong",[e._v("4.Client Credentials")])])]),e._v(" "),o("h3",{attrs:{id:"access-token"}},[o("a",{staticClass:"header-anchor",attrs:{href:"#access-token"}},[e._v("#")]),e._v(" Access Token")]),e._v(" "),o("pre",[o("code",[e._v("to access protected resources\n")])]),e._v(" "),o("h3",{attrs:{id:"refresh-token"}},[o("a",{staticClass:"header-anchor",attrs:{href:"#refresh-token"}},[e._v("#")]),e._v(" Refresh Token")]),e._v(" "),o("pre",[o("code",[e._v("to get new access_token\n\n\n+--------+                                           +---------------+\n|        |--(A)------- Authorization Grant ---------\x3e|               |\n|        |                                           |               |\n|        |<-(B)----------- Access Token -------------|               |\n|        |               & Refresh Token             |               |\n|        |                                           |               |\n|        |                            +----------+   |               |\n|        |--(C)---- Access Token ----\x3e|          |   |               |\n|        |                            |          |   |               |\n|        |<-(D)- Protected Resource --| Resource |   | Authorization |\n| Client |                            |  Server  |   |     Server    |\n|        |--(E)---- Access Token ----\x3e|          |   |               |\n|        |                            |          |   |               |\n|        |<-(F)- Invalid Token Error -|          |   |               |\n|        |                            +----------+   |               |\n|        |                                           |               |\n|        |--(G)----------- Refresh Token -----------\x3e|               |\n|        |                                           |               |\n|        |<-(H)----------- Access Token -------------|               |\n+--------+           & Optional Refresh Token        +---------------+\n")])])])}),[],!1,null,null,null);t.default=r.exports}}]);