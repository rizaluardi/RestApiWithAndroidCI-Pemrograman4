<?php
defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
class instansi_android extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        	$this->load->database();
    }

    //Menampilkan data kontak
    function index_get() { 
        $instansi = $this->db->get('instansi')->result();
        $this->response(array("result"=>$instansi, 200));
    }

}
?>
