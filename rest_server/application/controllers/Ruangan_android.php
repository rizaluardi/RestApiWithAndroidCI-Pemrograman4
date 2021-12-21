<?php
defined('BASEPATH') OR exit('No direct script access allowed');

require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
class ruangan_android extends REST_Controller {

    function __construct($config = 'rest') {
        parent::__construct($config);
        	$this->load->database();
    }

    //Menampilkan data kontak
    function index_get(){
    $id_ruangan = $this->get('id_ruangan');
		if ($id_ruangan == '') {
			$ruangan = $this->db->get('ruangan')->result();
		} else {
			$this->db->where('id_ruangan', $id_ruangan);
			$ruangan = $this->db->get('ruangan')->result();
		}
        $this->response(array("result"=>$ruangan, 200));
    }

}
?>
