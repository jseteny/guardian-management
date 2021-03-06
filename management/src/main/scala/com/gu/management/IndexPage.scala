package com.gu.management

case class IndexPage(pages: Seq[ManagementPage], applicationName: String, version: String) extends HtmlManagementPage {
  val path = "/management"
  val title = "Management Index"

  def body(r: HttpRequest) =
    <xml:group>
      <ul>
        {
          for (p <- pages) yield <li>
                                   <a href={ p.url }>
                                     { p.linktext }
                                   </a>
                                 </li>
        }
      </ul>
      <hr/>
      <p>
        <small>
          This page generated by
          <a href="http://github.com/guardian/guardian-management">guardian-management</a>{ version }
        </small>
      </p>
    </xml:group>

}
