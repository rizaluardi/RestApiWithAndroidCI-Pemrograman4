<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
class Ruangan extends REST_Controller {
	function __construct($config = 'rest') {
		parent::__construct($config);
		$this->load->database();
	}
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
	function index_post() {
		$data = array(
			'id_ruangan' => $this->post('id_ruangan'),
			'ruangan' => $this->post('ruangan'),
			'nomor' => $this->post('nomor'));
		$insert = $this->db->insert('ruangan', $data);
		if ($insert) {
			$this->response($data, 200);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
	function index_put() {
		$id_ruangan = $this->put('id_ruangan');
		$data = array(
			'id_ruangan' => $this->put('id_ruangan'),
			'ruangan' => $this->put('ruangan'),
			'nomor' => $this->put('nomor'));
		$this->db->where('id_ruangan', $id_ruangan);
		$update = $this->db->update('ruangan', $data);
		if ($update) {
			$this->response($data, 200);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}
	function index_delete() {
		$id_ruangan = $this->delete('id_ruangan');
		$this->db->where('id_ruangan', $id_ruangan);
		$delete = $this->db->delete('ruangan');
		if ($delete) {
			$this->response(array('status' => 'success'), 201);
		} else {
			$this->response(array('status' => 'fail', 502));
		}
	}

}
?>